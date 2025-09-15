package com.scaler.productservicesept25.services;

import com.scaler.productservicesept25.dtos.FakeStoreProductDto;
import com.scaler.productservicesept25.exceptions.ProductNotFoundExceptions;
import com.scaler.productservicesept25.models.Category;
import com.scaler.productservicesept25.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private final RestTemplate restTemplate;
    private final RedisTemplate<String,Object> redisTemplate;

    public FakeStoreProductService(RestTemplate restTemplate, RedisTemplate<String,Object> redisTemplate) {
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }

    public static Product convertFakeStoreDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        if (fakeStoreProductDto == null) {
            return null;
        }
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setTitle(fakeStoreProductDto.getTitle());

        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundExceptions {

        //first check if the product with this productId exists in Redis cache
        //if exists, return the product from Redis cache
        Product product = (Product) redisTemplate.opsForHash().get("PRODUCTS","PRODUCT_"+productId);
        if(product != null){
            return product;
            //CACHE HIT
        }

        //if not exists(i.e product==null), call the external API to fetch the product details
        //CACHE MISS
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity =
                restTemplate.getForEntity("https://fakestoreapi.com/products/" + productId,
                        FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductDtoResponseEntity.getBody();

        if (fakeStoreProductDto == null) {
            throw new ProductNotFoundExceptions(productId);
        }
        //save the fetched product in Redis cache
        product = convertFakeStoreDtoToProduct(fakeStoreProductDto);
        redisTemplate.opsForHash().put("PRODUCTS","PRODUCT_"+productId,product);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        ResponseEntity<FakeStoreProductDto[]> fakeStoreProductDtoResponseEntity =
                restTemplate.getForEntity("https://fakestoreapi.com/products/", FakeStoreProductDto[].class);

        FakeStoreProductDto[] fakeStoreProductDtos = fakeStoreProductDtoResponseEntity.getBody();

        if (fakeStoreProductDtos == null) {
            return List.of();
        }

        List<Product> products = new java.util.ArrayList<>();
        for (FakeStoreProductDto dto : fakeStoreProductDtos) {
            Product product = convertFakeStoreDtoToProduct(dto);
            products.add(product);
        }
        return products;
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

    @Override
    public Page<Product> getProductByTitle(String title, int pageNumber, int pageSize) {
        return null;
    }
}
