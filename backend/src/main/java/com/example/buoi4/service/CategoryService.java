package com.example.buoi4.service;

import com.example.buoi4.dto.CategoryRequest;
import com.example.buoi4.model.Category;
import com.example.buoi4.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public Category createCategory(CategoryRequest request) {
        Category category = new Category(
            request.getCategoryName(),
            request.getCategoryImage(),
            request.getCategoryDescription()
        );
        return categoryRepository.save(category);
    }
    
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    
    public Category getCategoryById(int categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }
    
    public Category updateCategory(int categoryId, CategoryRequest request) {
        Category category = getCategoryById(categoryId);
        
        category.setCategoryName(request.getCategoryName());
        category.setCategoryImage(request.getCategoryImage());
        category.setCategoryDescription(request.getCategoryDescription());
        
        return categoryRepository.save(category);
    }
    
    public void deleteCategory(int categoryId) {
        categoryRepository.deleteById(categoryId);
    }
    
    public List<Category> searchCategoriesByName(String name) {
        return categoryRepository.searchByName(name);
    }
    
    public List<Category> getCategoriesWithProductCount() {
        return categoryRepository.findCategoriesWithProductCount();
    }
}