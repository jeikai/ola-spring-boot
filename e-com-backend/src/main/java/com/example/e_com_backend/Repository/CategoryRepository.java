package com.example.e_com_backend.Repository;

import com.example.e_com_backend.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Query("SELECT c FROM Category c WHERE c.categoryName = :name")
    Optional<Category> findByCategoryName(@Param("name") String name);

    @Query("SELECT c FROM Category c WHERE c.categoryName LIKE %:name%")
    List<Category> searchByName(@Param("name") String name);

    @Query(value = "SELECT c.*, COUNT(p.product_id) as product_count " +
            "FROM categories c LEFT JOIN products p ON c.category_id = p.category_id " +
            "GROUP BY c.category_id ORDER BY product_count DESC", nativeQuery = true)
    List<Category> findCategoriesWithProductCount();


}
