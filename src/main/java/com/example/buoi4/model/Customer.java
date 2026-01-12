package com.example.buoi4.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "customer_email", nullable = false, unique = true)
    private String customerEmail;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "postcode", length = 20)
    private String postcode;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "phone", length = 20)
    private String phone;

    public Customer() {

    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public int getCustomerId() {
        return customerId;
    }
}
