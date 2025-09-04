package com.scaler.productservicesept25.services;

import com.scaler.productservicesept25.models.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId);
    List<Product> getAllProducts();
    Product createProduct(Product product);
    ResponseEntity<Void> deleteProduct(Long productId);
    ResponseEntity<Product> updateProduct(Long productId, Product updates);
    ResponseEntity<Product> replaceProduct(Long productId, Product newProduct);
}
