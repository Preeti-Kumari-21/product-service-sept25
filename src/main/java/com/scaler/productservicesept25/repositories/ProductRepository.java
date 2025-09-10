package com.scaler.productservicesept25.repositories;

import com.scaler.productservicesept25.models.Category;
import com.scaler.productservicesept25.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    Optional<Product> findById(Long aLong); //select * from products where id=?

    List<Product> findByTitle(String title); //select * from products where title=?

    List<Product> findByTitleContainsIgnoreCase(String title); //select * from products where title like '%title%';

    List<Product> findByPriceBetween(Double priceAfter, Double priceBefore); //select * from products where price between ? and ?;

    List<Product> findByCategory(Category category); //select * from products where category_id=?;

    List<Product> findByCategory_Id(Long categoryId); //select * from products where category_id=?;

    List<Product> findByCategoryTitle(String categoryTitle); //select * from products p join categories c on p.category_id=c.id where c.title=?;

    @Query("select p.title from products p where p.id=?1")
    Optional<Product> findOnlyProductTitleById(Long productId); //select title from products where id=?;

    Product save(Product product);

    @Override
    void deleteById(Long productId);

    @Query(value = "select * from products p where p.id=:id", nativeQuery = true)
    Product findProductWithGivenId(@Param("id") long productId);
}
