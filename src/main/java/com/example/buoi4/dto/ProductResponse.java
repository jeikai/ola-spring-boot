package com.example.buoi4.dto;

import java.math.BigDecimal;

public class ProductResponse {
    private int productId;
    private String productName;
    private String productDesc;
    private String image1;
    private String image2;
    private String image3;
    private BigDecimal price;
    private int stock;
    private Integer categoryId;
    private String categoryName;

    public ProductResponse() {
    }

    public ProductResponse(int productId, String productName, String productDesc, String image1, 
                          String image2, String image3, BigDecimal price, int stock, 
                          Integer categoryId, String categoryName) {
        this.productId = productId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.price = price;
        this.stock = stock;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}