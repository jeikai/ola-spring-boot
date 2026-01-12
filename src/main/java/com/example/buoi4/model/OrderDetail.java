package com.example.buoi4.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_details_id")
    private int orderDetailsId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_qty")
    private int productQty;

    @Column(name = "product_price", precision = 10, scale = 2)
    private BigDecimal product_price;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "subtotal", precision = 10, scale = 2)
    private BigDecimal subtotal;

    public OrderDetail() {

    }
}