package com.example.e_com_backend.Repository;

import com.example.e_com_backend.Entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    @Query(value = "SELECT od.order_details_id, od.product_id, p.product_name, " +
            "od.product_qty, od.product_price, od.subtotal " +
            "FROM order_details od " +
            "JOIN products p ON od.product_id = p.product_id " +
            "WHERE od.order_id = :orderId", nativeQuery = true)
    List<Object[]> findOrderDetailsByOrderIdWithProduct(@Param("orderId") int orderId);

    @Query("SELECT od FROM OrderDetail od WHERE od.orderId = :orderId")
    List<OrderDetail> findByOrderId(@Param("orderId") int orderId);

    @Query("SELECT od FROM OrderDetail od WHERE od.productId = :productId")
    List<OrderDetail> findByProductId(@Param("productId") int productId);

    @Query(value = "SELECT p.product_id, p.product_name, SUM(od.product_qty) as total_sold " +
            "FROM order_details od " +
            "JOIN products p ON od.product_id = p.product_id " +
            "GROUP BY p.product_id, p.product_name " +
            "ORDER BY total_sold DESC LIMIT 5", nativeQuery = true)
    List<Object[]> findTopSellingProductsWithQuantity();
}
