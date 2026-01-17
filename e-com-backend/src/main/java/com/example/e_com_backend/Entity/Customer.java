package com.example.e_com_backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "customer_email", nullable = false, unique = true, length = 100)
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

    // No-args constructor (required by JPA)
    public Customer() {
    }

    // All-args constructor
    public Customer(int customerId, String customerEmail, String firstName, String lastName,
                    String password, String address, String postcode, String city, String phone) {
        this.customerId = customerId;
        this.customerEmail = customerEmail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
        this.postcode = postcode;
        this.city = city;
        this.phone = phone;
    }

    // Custom constructor
    public Customer(String customerEmail, String firstName, String lastName, String password) {
        this.customerEmail = customerEmail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    // Getter & Setter

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
