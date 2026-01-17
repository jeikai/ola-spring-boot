package com.example.e_com_backend.dto;

public class OrderItemRequest {

    private int productId;
    private int quantity;

    // No-args constructor
    public OrderItemRequest() {
    }

    // All-args constructor
    public OrderItemRequest(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getter & Setter

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
