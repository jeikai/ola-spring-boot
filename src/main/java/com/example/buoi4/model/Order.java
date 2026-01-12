package com.example.buoi4.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "order_no", nullable = false, length = 50)
    private String orderNo;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "order_total", precision = 10, scale = 2)
    private BigDecimal orderTotal;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "shipping_date")
    private LocalDateTime shippingDate;

    @Column(name = "is_delivered")
    private Boolean isDelivered;

    public Order() {

    }
}