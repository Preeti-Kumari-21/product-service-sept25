package com.scaler.productservicesept25.repositories;

import com.scaler.productservicesept25.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{

    @Override
    Optional<Category> findById(Long aLong); //select * from categories where id=?

    Optional<Category> findByTitle(String title); //select * from categories where title=?

    List<Category> findByTitleContainsIgnoreCase(String title); //select * from categories where title like '%title%';

    @Query("select c.title from categories c where c.id=?1")
    Optional<Category> findOnlyCategoryTitleById(Long categoryId);

    @Override
    void deleteById(Long categoryId);
}
