package com.scaler.productservicesept25;

import com.scaler.productservicesept25.models.Category;
import com.scaler.productservicesept25.models.Product;
import com.scaler.productservicesept25.repositories.CategoryRepository;
import com.scaler.productservicesept25.repositories.ProductRepository;
import com.scaler.productservicesept25.services.ProductService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceSept25ApplicationTests {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

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

    @Test
    public void checkProductFetchTypes(){
        System.out.println("DEBUG-3");
        Optional<Product> optionalProduct = productRepository.findById(1L); // No collection attributes in Product model
        //Hence no lazy loading
        //EAGER fetch
    }

    @Test
    @Transactional
    public void checkCategoryFetchTypes(){
        System.out.println("DEBUG-4");
        Optional<Category> optionalCategory = categoryRepository.findById(1L); //LAZY fetch

        //Using the below line we are trying to access the collection attribute of Category if and only if user wants the products detail
        List<Product> products = optionalCategory.get().getProducts();

        System.out.println("DEBUG-5");
        System.out.println(products.get(0).getCategory());
        //select * from products where category_id = 1
    }


}
