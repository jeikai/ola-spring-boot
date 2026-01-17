package com.example.e_com_backend.Service;

import com.example.e_com_backend.Entity.Product;
import com.example.e_com_backend.Repository.ProductRepository;
import com.example.e_com_backend.dto.ProductRequest;
import com.example.e_com_backend.dto.ProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(ProductRequest request) {
        Product product = new Product(
                request.getProductName(),
                request.getProductDesc(),
                request.getPrice(),
                request.getStock(),
                request.getCategoryId()
        );
        product.setImage1(request.getImage1());
        product.setImage2(request.getImage2());
        product.setImage3(request.getImage3());

        return productRepository.save(product);
    }

    public List<ProductResponse> getAllProductsWithCategory() {
        List<Object[]> results = productRepository.findAllProductsWithCategory();
        return mapToProductResponseList(results);
    }

    public Product getProductById(int productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product updateProduct(int productId, ProductRequest request) {
        Product product = getProductById(productId);

        product.setProductName(request.getProductName());
        product.setProductDesc(request.getProductDesc());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setCategoryId(request.getCategoryId());
        product.setImage1(request.getImage1());
        product.setImage2(request.getImage2());
        product.setImage3(request.getImage3());

        return productRepository.save(product);
    }

    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }

    public List<ProductResponse> getProductsByCategory(int categoryId) {
        List<Object[]> results = productRepository.findProductsByCategoryWithDetails(categoryId);
        return mapToProductResponseList(results);
    }

    public List<ProductResponse> searchProducts(String keyword) {
        List<Object[]> results = productRepository.searchProductsWithCategory(keyword);
        return mapToProductResponseList(results);
    }


    public List<Product> getProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.findByPriceRange(minPrice, maxPrice);
    }

    public List<Product> getAvailableProducts() {
        return productRepository.findAvailableProducts();
    }

    public List<Product> getTopSellingProducts() {
        return productRepository.findTopSellingProducts();
    }

    public Product updateStock(int productId, int quantity) {
        Product product = getProductById(productId);
        product.setStock(product.getStock() + quantity);
        return productRepository.save(product);
    }

    public boolean reduceStock(int productId, int quantity) {
        Product product = getProductById(productId);
        if (product.getStock() >= quantity) {
            product.setStock(product.getStock() - quantity);
            productRepository.save(product);
            return true;
        }
        return false;
    }

    private List<ProductResponse> mapToProductResponseList(List<Object[]> results) {
        List<ProductResponse> products = new ArrayList<>();
        for (Object[] row : results) {
            ProductResponse response = new ProductResponse();
            response.setProductId(((Number) row[0]).intValue());
            response.setProductName((String) row[1]);
            response.setProductDesc((String) row[2]);
            response.setImage1((String) row[3]);
            response.setImage2((String) row[4]);
            response.setImage3((String) row[5]);
            response.setPrice((BigDecimal) row[6]);
            response.setStock(((Number) row[7]).intValue());
            response.setCategoryId(row[8] != null ? ((Number) row[8]).intValue() : null);
            response.setCategoryName((String) row[9]);
            products.add(response);
        }
        return products;
    }

}
