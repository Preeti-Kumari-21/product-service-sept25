package com.scaler.productservicesept25;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProductServiceSept25Application {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceSept25Application.class, args);
    }

}
