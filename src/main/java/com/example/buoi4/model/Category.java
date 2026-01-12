package com.example.buoi4.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false, unique = true)
    private int category_id;

    @Column(name = "category_name", length = 100)
    private String category_name;

    @Column(name = "category_image", length = 255)
    private String category_image;

    @Column(name = "category_description", columnDefinition = "TEXT")
    private String category_description;

    public Category() {

    }
}
