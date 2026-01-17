package com.example.e_com_backend.Service;

import com.example.e_com_backend.Entity.Order;
import com.example.e_com_backend.Entity.OrderDetail;
import com.example.e_com_backend.Entity.Product;
import com.example.e_com_backend.Repository.OrderDetailRepository;
import com.example.e_com_backend.Repository.OrderRepository;
import com.example.e_com_backend.dto.OrderDetailResponse;
import com.example.e_com_backend.dto.OrderItemRequest;
import com.example.e_com_backend.dto.OrderRequest;
import com.example.e_com_backend.dto.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductService productService;

    @Transactional
    public OrderResponse createOrder(OrderRequest request) {
        // Generate order number
        String orderNo = generateOrderNumber();

        // Calculate total and validate stock
        BigDecimal totalAmount = BigDecimal.ZERO;
        List<OrderDetail> orderDetails = new ArrayList<>();

        for (OrderItemRequest item : request.getItems()) {
            Product product = productService.getProductById(item.getProductId());

            // Check stock availability
            if (product.getStock() < item.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getProductName());
            }

            BigDecimal subtotal = product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
            totalAmount = totalAmount.add(subtotal);
        }

        // Create order
        Order order = new Order(orderNo, totalAmount, request.getCustomerId());
        Order savedOrder = orderRepository.save(order);

        // Create order details and update stock
        for (OrderItemRequest item : request.getItems()) {
            Product product = productService.getProductById(item.getProductId());

            BigDecimal subtotal = product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));

            OrderDetail orderDetail = new OrderDetail(
                    item.getProductId(),
                    item.getQuantity(),
                    product.getPrice(),
                    savedOrder.getOrderId(),
                    subtotal
            );

            orderDetailRepository.save(orderDetail);

            // Reduce stock
            productService.reduceStock(item.getProductId(), item.getQuantity());
        }

        return getOrderById(savedOrder.getOrderId());
    }

    public OrderResponse getOrderById(int orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        // Get order details with product names
        List<Object[]> detailResults = orderDetailRepository.findOrderDetailsByOrderIdWithProduct(orderId);
        List<OrderDetailResponse> orderDetails = new ArrayList<>();

        for (Object[] row : detailResults) {
            OrderDetailResponse detail = new OrderDetailResponse(
                    ((Number) row[0]).intValue(), // order_details_id
                    ((Number) row[1]).intValue(), // product_id
                    (String) row[2],              // product_name
                    ((Number) row[3]).intValue(), // product_qty
                    (BigDecimal) row[4],          // product_price
                    (BigDecimal) row[5]           // subtotal
            );
            orderDetails.add(detail);
        }

        OrderResponse response = new OrderResponse();
        response.setOrderId(order.getOrderId());
        response.setOrderNo(order.getOrderNo());
        response.setOrderDate(order.getOrderDate());
        response.setOrderTotal(order.getOrderTotal());
        response.setCustomerId(order.getCustomerId());
        response.setShippingDate(order.getShippingDate());
        response.setDelivered(order.isDelivered());
        response.setOrderDetails(orderDetails);

        return response;
    }

    public List<OrderResponse> getOrdersByCustomer(int customerId) {
        List<Object[]> results = orderRepository.findOrdersByCustomerWithDetails(customerId);
        return mapToOrderResponseList(results);
    }

    public List<OrderResponse> getAllOrders() {
        List<Object[]> results = orderRepository.findAllOrdersWithCustomerDetails();
        return mapToOrderResponseList(results);
    }

    public Order updateOrderStatus(int orderId, boolean isDelivered, LocalDateTime shippingDate) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setDelivered(isDelivered);
        if (shippingDate != null) {
            order.setShippingDate(shippingDate);
        }

        return orderRepository.save(order);
    }

    public List<Order> getOrdersByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return orderRepository.findOrdersByDateRange(startDate, endDate);
    }

    public List<Order> getOrdersByDeliveryStatus(boolean delivered) {
        return orderRepository.findOrdersByDeliveryStatus(delivered);
    }

    public BigDecimal getTodaysTotalSales() {
        return orderRepository.getTodaysTotalSales();
    }

    public int getCustomerOrderCount(int customerId) {
        return orderRepository.countOrdersByCustomer(customerId);
    }

    private String generateOrderNumber() {
        String dateStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        Random random = new Random();
        int randomNum = 1000 + random.nextInt(9000);
        return "ORD" + dateStr + randomNum;
    }

    private List<OrderResponse> mapToOrderResponseList(List<Object[]> results) {
        List<OrderResponse> orders = new ArrayList<>();
        for (Object[] row : results) {
            OrderResponse response = new OrderResponse();
            response.setOrderId(((Number) row[0]).intValue());
            response.setOrderNo((String) row[1]);
            response.setOrderDate((LocalDateTime) row[2]);
            response.setOrderTotal((BigDecimal) row[3]);
            response.setCustomerId(((Number) row[4]).intValue());
            response.setCustomerName((String) row[5]);
            response.setCustomerEmail((String) row[6]);
            response.setShippingDate((LocalDateTime) row[7]);
            response.setDelivered((Boolean) row[8]);
            orders.add(response);
        }
        return orders;
    }
}
