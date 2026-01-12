package com.example.buoi4.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name", nullable = false, unique = true)
    private String productName;

    @Column(name = "product_desc", columnDefinition = "TEXT")
    private String productDesc;

    @Column(name = "image1", length = 255)
    private String image1;

    @Column(name = "image1", length = 255)
    private String image2;

    @Column(name = "image1", length = 255)
    private String image3;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "stock")
    private int stock;

    @Column(name = "category_id")
    private Integer categoryId;

    public Product() {

    }
}