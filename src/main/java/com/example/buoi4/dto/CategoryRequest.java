package com.example.buoi4.dto;

public class CategoryRequest {
    private String categoryName;
    private String categoryImage;
    private String categoryDescription;

    public CategoryRequest() {
    }

    public CategoryRequest(String categoryName, String categoryImage, String categoryDescription) {
        this.categoryName = categoryName;
        this.categoryImage = categoryImage;
        this.categoryDescription = categoryDescription;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }
}