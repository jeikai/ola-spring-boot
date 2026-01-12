package com.example.buoi4.dto;

public class CustomerLoginRequest {
    private String customerEmail;
    private String password;

    public CustomerLoginRequest() {
    }

    public CustomerLoginRequest(String customerEmail, String password) {
        this.customerEmail = customerEmail;
        this.password = password;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}