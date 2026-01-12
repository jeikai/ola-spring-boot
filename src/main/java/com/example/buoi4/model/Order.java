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

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "shipping_date")
    private LocalDateTime shippingDate;

    @Column(name = "is_delivered")
    private boolean isDelivered = false;

    public Order() {
        this.orderDate = LocalDateTime.now();
    }

    public Order(String orderNo, BigDecimal orderTotal, Integer customerId) {
        this.orderNo = orderNo;
        this.orderTotal = orderTotal;
        this.customerId = customerId;
        this.orderDate = LocalDateTime.now();
    }

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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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
}