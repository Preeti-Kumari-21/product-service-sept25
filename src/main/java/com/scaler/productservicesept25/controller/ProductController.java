package com.scaler.productservicesept25.controller;

import com.scaler.productservicesept25.models.Product;
import com.scaler.productservicesept25.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")        // http://localhost:8081/products
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")            // http://localhost:8081/products/1
    public Product getSingleProduct(@PathVariable("id") Long productId) {
        // Logic to get a single product by ID
      return productService.getSingleProduct(productId);
    }

    @GetMapping("/")        // http://localhost:8081/products/
    public List<Product> getAllProducts(){
        //Return all products
          return productService.getAllProducts();
    }

    @PostMapping("/")    // http://localhost:8081/products/
    public Product createProduct(@RequestBody Product product){
        return new Product();
    }

    @DeleteMapping("/{id}")   // http://localhost:8081/products/1
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long productId){
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")   // http://localhost:8081/products/1
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long productId,
                                                 @RequestBody Product updates){
        return ResponseEntity.ok(new Product());
    }

    @PutMapping("/{id}")  // http://localhost:8081/products/1
    public ResponseEntity<Product> replaceProduct(@PathVariable("id") Long productId,
                                                  @RequestBody Product newProduct){
        return ResponseEntity.ok(new Product());
    }
}
