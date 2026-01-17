package com.example.e_com_backend.dto;

import java.util.List;

public class OrderRequest {

    private int customerId;
    private List<OrderItemRequest> items;

    // No-args constructor
    public OrderRequest() {
    }

    // All-args constructor
    public OrderRequest(int customerId, List<OrderItemRequest> items) {
        this.customerId = customerId;
        this.items = items;
    }

    // Getter & Setter

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<OrderItemRequest> getItems() {
        return items;
    }

    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }
}
