package com.example.e_com_backend.Repository;

import com.example.e_com_backend.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Query(value = "SELECT o.order_id, o.order_no, o.order_date, o.order_total, " +
            "o.customer_id, CONCAT(c.first_name, ' ', c.last_name) as customer_name, " +
            "c.customer_email, o.shipping_date, o.is_delivered " +
            "FROM orders o " +
            "JOIN customers c ON o.customer_id = c.customer_id " +
            "WHERE o.customer_id = :customerId " +
            "ORDER BY o.order_date DESC", nativeQuery = true)
    List<Object[]> findOrdersByCustomerWithDetails(@Param("customerId") int customerId);

    @Query(value = "SELECT o.order_id, o.order_no, o.order_date, o.order_total, " +
            "o.customer_id, CONCAT(c.first_name, ' ', c.last_name) as customer_name, " +
            "c.customer_email, o.shipping_date, o.is_delivered " +
            "FROM orders o " +
            "JOIN customers c ON o.customer_id = c.customer_id " +
            "ORDER BY o.order_date DESC", nativeQuery = true)
    List<Object[]> findAllOrdersWithCustomerDetails();

    @Query("SELECT o FROM Order o WHERE o.orderDate BETWEEN :startDate AND :endDate")
    List<Order> findOrdersByDateRange(@Param("startDate") LocalDateTime startDate,
                                      @Param("endDate") LocalDateTime endDate);

    @Query("SELECT o FROM Order o WHERE o.isDelivered = :delivered")
    List<Order> findOrdersByDeliveryStatus(@Param("delivered") boolean delivered);

    @Query(value = "SELECT SUM(o.order_total) FROM orders o " +
            "WHERE DATE(o.order_date) = CURRENT_DATE", nativeQuery = true)
    BigDecimal getTodaysTotalSales();

    @Query(value = "SELECT COUNT(*) FROM orders o " +
            "WHERE o.customer_id = :customerId", nativeQuery = true)
    int countOrdersByCustomer(@Param("customerId") int customerId);
}
