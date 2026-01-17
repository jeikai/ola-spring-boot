package com.example.e_com_backend.dto;

import java.math.BigDecimal;

public class ProductRequest {

    private String productName;
    private String productDesc;
    private String image1;
    private String image2;
    private String image3;
    private BigDecimal price;
    private int stock;
    private Integer categoryId;

    // No-args constructor
    public ProductRequest() {
    }

    // All-args constructor
    public ProductRequest(String productName, String productDesc,
                          String image1, String image2, String image3,
                          BigDecimal price, int stock, Integer categoryId) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.price = price;
        this.stock = stock;
        this.categoryId = categoryId;
    }

    // Getter & Setter

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
