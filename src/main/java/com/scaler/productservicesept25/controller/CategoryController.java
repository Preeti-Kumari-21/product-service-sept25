package com.scaler.productservicesept25.controller;

import com.scaler.productservicesept25.services.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(@Qualifier("selfCategoryService") CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
