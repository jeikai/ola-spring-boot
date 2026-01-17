package com.example.e_com_backend.dto;

import java.math.BigDecimal;

public class OrderDetailResponse {

    private int orderDetailsId;
    private int productId;
    private String productName;
    private int productQty;
    private BigDecimal productPrice;
    private BigDecimal subtotal;

    // No-args constructor
    public OrderDetailResponse() {
    }

    // All-args constructor
    public OrderDetailResponse(int orderDetailsId, int productId, String productName,
                               int productQty, BigDecimal productPrice, BigDecimal subtotal) {
        this.orderDetailsId = orderDetailsId;
        this.productId = productId;
        this.productName = productName;
        this.productQty = productQty;
        this.productPrice = productPrice;
        this.subtotal = subtotal;
    }

    // Getter & Setter

    public int getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(int orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
