package com.scaler.productservicesept25.services;

import com.scaler.productservicesept25.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service("selfCategoryService")
public class SelfCategoryService implements CategoryService {

    private final CategoryRepository categoryRepository;

    public SelfCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
