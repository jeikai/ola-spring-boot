package com.example.e_com_backend.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderResponse {

    private int orderId;
    private String orderNo;
    private LocalDateTime orderDate;
    private BigDecimal orderTotal;
    private int customerId;
    private String customerName;
    private String customerEmail;
    private LocalDateTime shippingDate;
    private boolean isDelivered;
    private List<OrderDetailResponse> orderDetails;

    // No-args constructor
    public OrderResponse() {
    }

    // All-args constructor
    public OrderResponse(int orderId, String orderNo, LocalDateTime orderDate,
                         BigDecimal orderTotal, int customerId, String customerName,
                         String customerEmail, LocalDateTime shippingDate,
                         boolean isDelivered, List<OrderDetailResponse> orderDetails) {
        this.orderId = orderId;
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.shippingDate = shippingDate;
        this.isDelivered = isDelivered;
        this.orderDetails = orderDetails;
    }

    // Getter & Setter

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public LocalDateTime getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDateTime shippingDate) {
        this.shippingDate = shippingDate;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public List<OrderDetailResponse> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailResponse> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
