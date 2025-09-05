package com.scaler.productservicesept25.services;

import com.scaler.productservicesept25.exceptions.ProductNotFoundExceptions;
import com.scaler.productservicesept25.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService{
    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundExceptions {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteProduct(Long productId) {
        return null;
    }

    @Override
    public ResponseEntity<Product> updateProduct(Long productId, Product updates) {
        return null;
    }

    @Override
    public ResponseEntity<Product> replaceProduct(Long productId, Product newProduct) {
        return null;
    }
}
