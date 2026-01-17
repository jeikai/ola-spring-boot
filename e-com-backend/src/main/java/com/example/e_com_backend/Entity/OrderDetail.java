package com.example.e_com_backend.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_details_id")
    private int orderDetailsId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_qty", nullable = false)
    private int productQty;

    @Column(name = "product_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal productPrice;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "subtotal", precision = 10, scale = 2)
    private BigDecimal subtotal;

    // No-args constructor (required by JPA)
    public OrderDetail() {
    }

    // All-args constructor
    public OrderDetail(int orderDetailsId, Integer productId, int productQty,
                       BigDecimal productPrice, Integer orderId, BigDecimal subtotal) {
        this.orderDetailsId = orderDetailsId;
        this.productId = productId;
        this.productQty = productQty;
        this.productPrice = productPrice;
        this.orderId = orderId;
        this.subtotal = subtotal;
    }

    // Custom constructor
    public OrderDetail(Integer productId, int productQty,
                       BigDecimal productPrice, Integer orderId, BigDecimal subtotal) {
        this.productId = productId;
        this.productQty = productQty;
        this.productPrice = productPrice;
        this.orderId = orderId;
        this.subtotal = subtotal;
    }

    // Getter & Setter

    public int getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(int orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
