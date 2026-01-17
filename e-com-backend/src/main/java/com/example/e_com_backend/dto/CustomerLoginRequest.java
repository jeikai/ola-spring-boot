package com.example.e_com_backend.dto;

public class CustomerLoginRequest {

    private String customerEmail;
    private String password;

    // No-args constructor
    public CustomerLoginRequest() {
    }

    // All-args constructor
    public CustomerLoginRequest(String customerEmail, String password) {
        this.customerEmail = customerEmail;
        this.password = password;
    }

    // Getter & Setter

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
