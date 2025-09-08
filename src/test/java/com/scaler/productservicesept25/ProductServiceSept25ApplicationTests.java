package com.scaler.productservicesept25;

import com.scaler.productservicesept25.models.Product;
import com.scaler.productservicesept25.repositories.ProductRepository;
import com.scaler.productservicesept25.services.ProductService;
import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class ProductServiceSept25ApplicationTests {

    @Autowired
    ProductRepository productRepository;

/*    public ProductServiceSept25ApplicationTests(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }*/

    @Test
    void contextLoads() {
    }

    @Test
    public void testProductService(){
        Optional<Product> product1 = productRepository.findById(1L);
        System.out.println("DEBUG-1");

        Product product = productRepository.findProductWithGivenId(1L);
        System.out.println("DEBUG-2");
    }

}
