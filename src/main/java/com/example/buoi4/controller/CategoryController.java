package com.example.buoi4.controller;

import com.example.buoi4.dto.CategoryRequest;
import com.example.buoi4.model.Category;
import com.example.buoi4.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@CrossOrigin(origins = "*")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;
    
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CategoryRequest request) {
        try {
            Category category = categoryService.createCategory(request);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
    
    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int categoryId) {
        try {
            Category category = categoryService.getCategoryById(categoryId);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{categoryId}")
    public ResponseEntity<Category> updateCategory(@PathVariable int categoryId, 
                                                  @RequestBody CategoryRequest request) {
        try {
            Category category = categoryService.updateCategory(categoryId, request);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int categoryId) {
        try {
            categoryService.deleteCategory(categoryId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Category>> searchCategories(@RequestParam String name) {
        List<Category> categories = categoryService.searchCategoriesByName(name);
        return ResponseEntity.ok(categories);
    }
    
    @GetMapping("/with-product-count")
    public ResponseEntity<List<Category>> getCategoriesWithProductCount() {
        List<Category> categories = categoryService.getCategoriesWithProductCount();
        return ResponseEntity.ok(categories);
    }
}