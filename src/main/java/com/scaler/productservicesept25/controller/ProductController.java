package com.scaler.productservicesept25.controller;

import com.scaler.productservicesept25.commons.AuthCommons;
import com.scaler.productservicesept25.dtos.UserDto;
import com.scaler.productservicesept25.exceptions.CategoryNotFoundException;
import com.scaler.productservicesept25.exceptions.ProductNotFoundExceptions;
import com.scaler.productservicesept25.exceptions.UnauthorizedException;
import com.scaler.productservicesept25.models.Product;
import com.scaler.productservicesept25.repositories.ProductRepository;
import com.scaler.productservicesept25.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")        // http://localhost:8081/products
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;
    private final AuthCommons authCommons;

    public ProductController(@Qualifier("selfProductService") ProductService productService, ProductRepository productRepository, AuthCommons authCommons) {
        this.productService = productService;
        this.productRepository = productRepository;
        this.authCommons = authCommons;
    }

    @GetMapping("/{id}/{token}")            // http://localhost:8081/products/1
    public Product getSingleProduct(@PathVariable("id") Long productId, @PathVariable("token") String tokenValue) throws ProductNotFoundExceptions {
        // Logic to get a single product by ID

        UserDto userDto = authCommons.validateToken(tokenValue);

        if(userDto == null){
            throw new UnauthorizedException("Invalid Token");
        }
        return productService.getSingleProduct(productId);

        /*ResponseEntity<Product> responseEntity = new ResponseEntity<>(productService.getSingleProduct(productId),
                HttpStatus.OK);
        return responseEntity;*/
    }

    @GetMapping("/")        // http://localhost:8081/products/
    public List<Product> getAllProducts() {
        //Return all products
        return productService.getAllProducts();
    }

    @PostMapping("/")    // http://localhost:8081/products/
    public Product createProduct(@RequestBody Product product) throws CategoryNotFoundException {
        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")   // http://localhost:8081/products/1
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long productId) {
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")   // http://localhost:8081/products/1
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long productId,
                                                 @RequestBody Product updates) {
        return ResponseEntity.ok(new Product());
    }

    @PutMapping("/{id}")  // http://localhost:8081/products/1
    public ResponseEntity<Product> replaceProduct(@PathVariable("id") Long productId,
                                                  @RequestBody Product newProduct) {
        return ResponseEntity.ok(new Product());
    }
}
