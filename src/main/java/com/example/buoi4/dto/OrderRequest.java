package com.example.buoi4.dto;

import java.util.List;

public class OrderRequest {
    private int customerId;
    private List<OrderItemRequest> items;

    public OrderRequest() {
    }

    public OrderRequest(int customerId, List<OrderItemRequest> items) {
        this.customerId = customerId;
        this.items = items;
    }

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