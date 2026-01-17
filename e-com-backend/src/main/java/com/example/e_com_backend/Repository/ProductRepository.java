package com.example.e_com_backend.Repository;

import com.example.e_com_backend.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "SELECT p.product_id as productId, p.product_name as productName, " +
            "p.product_desc as productDesc, p.image1, p.image2, p.image3, " +
            "p.price, p.stock, p.category_id as categoryId, c.category_name as categoryName " +
            "FROM products p LEFT JOIN categories c ON p.category_id = c.category_id",
            nativeQuery = true)
    List<Object[]> findAllProductsWithCategory();

    @Query(value = "SELECT p.product_id as productId, p.product_name as productName, " +
            "p.product_desc as productDesc, p.image1, p.image2, p.image3, " +
            "p.price, p.stock, p.category_id as categoryId, c.category_name as categoryName " +
            "FROM products p LEFT JOIN categories c ON p.category_id = c.category_id " +
            "WHERE p.category_id = :categoryId", nativeQuery = true)
    List<Object[]> findProductsByCategoryWithDetails(@Param("categoryId") int categoryId);

    @Query(value = "SELECT p.product_id as productId, p.product_name as productName, " +
            "p.product_desc as productDesc, p.image1, p.image2, p.image3, " +
            "p.price, p.stock, p.category_id as categoryId, c.category_name as categoryName " +
            "FROM products p LEFT JOIN categories c ON p.category_id = c.category_id " +
            "WHERE p.product_name LIKE %:keyword% OR p.product_desc LIKE %:keyword%",
            nativeQuery = true)
    List<Object[]> searchProductsWithCategory(@Param("keyword") String keyword);

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    List<Product> findByPriceRange(@Param("minPrice") BigDecimal minPrice, @Param("maxPrice") BigDecimal maxPrice);

    @Query("SELECT p FROM Product p WHERE p.stock > 0")
    List<Product> findAvailableProducts();

    @Query(value = "SELECT p.* FROM products p " +
            "JOIN order_details od ON p.product_id = od.product_id " +
            "GROUP BY p.product_id " +
            "ORDER BY SUM(od.product_qty) DESC LIMIT 10", nativeQuery = true)
    List<Product> findTopSellingProducts();
}
