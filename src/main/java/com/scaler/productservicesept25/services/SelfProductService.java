package com.scaler.productservicesept25.services;

import com.scaler.productservicesept25.exceptions.CategoryNotFoundException;
import com.scaler.productservicesept25.exceptions.ProductNotFoundExceptions;
import com.scaler.productservicesept25.models.Category;
import com.scaler.productservicesept25.models.Product;
import com.scaler.productservicesept25.repositories.CategoryRepository;
import com.scaler.productservicesept25.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService{

    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundExceptions {
/*        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundExceptions(productId);
        }
        return optionalProduct.get();*/

        return productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundExceptions(productId));

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) throws CategoryNotFoundException {
        //Check for category as it's an object inside product
         Category category = product.getCategory();

        if(category == null){
            //throw some exception
            throw new CategoryNotFoundException("Category is required to create a product");
        }

        Optional<Category> optionalCategory = categoryRepository.findByTitle(category.getTitle());

        if(optionalCategory.isEmpty()){
            //there is no category in the DB with this title
            //Create and save this category first
            category = categoryRepository.save(category);
        }else{
            category = optionalCategory.get();
        }
        product.setCategory(category);
        return productRepository.save(product);
    }

    @Override
    public ResponseEntity<Void> deleteProduct(Long productId) {
        productRepository.deleteById(productId);
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
