package com.scaler.productservicesept25.services;

import com.scaler.productservicesept25.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    @Override
    public Product getSingleProduct(Long productId) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForEntity("https://fakestoreapi.com/products/" + productId, Product.class);
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
