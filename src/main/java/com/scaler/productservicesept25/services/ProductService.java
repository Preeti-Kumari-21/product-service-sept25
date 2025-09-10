package com.scaler.productservicesept25.services;

import com.scaler.productservicesept25.exceptions.CategoryNotFoundException;
import com.scaler.productservicesept25.exceptions.ProductNotFoundExceptions;
import com.scaler.productservicesept25.models.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId) throws ProductNotFoundExceptions;

    List<Product> getAllProducts();

    Product createProduct(Product product) throws CategoryNotFoundException;

    ResponseEntity<Void> deleteProduct(Long productId);

    ResponseEntity<Product> updateProduct(Long productId, Product updates);

    ResponseEntity<Product> replaceProduct(Long productId, Product newProduct);
}
