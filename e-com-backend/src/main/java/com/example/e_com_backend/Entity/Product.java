package com.example.e_com_backend.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name", nullable = false, length = 100)
    private String productName;

    @Column(name = "product_desc", columnDefinition = "TEXT")
    private String productDesc;

    @Column(name = "image1", length = 255)
    private String image1;

    @Column(name = "image2", length = 255)
    private String image2;

    @Column(name = "image3", length = 255)
    private String image3;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "stock")
    private int stock = 0;

    @Column(name = "category_id")
    private Integer categoryId;

    // No-args constructor (required by JPA)
    public Product() {
    }

    // All-args constructor
    public Product(int productId, String productName, String productDesc,
                   String image1, String image2, String image3,
                   BigDecimal price, int stock, Integer categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.price = price;
        this.stock = stock;
        this.categoryId = categoryId;
    }

    // Custom constructor
    public Product(String productName, String productDesc,
                   BigDecimal price, int stock, Integer categoryId) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.price = price;
        this.stock = stock;
        this.categoryId = categoryId;
    }

    // Getter & Setter

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

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
