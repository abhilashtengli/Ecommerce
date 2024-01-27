package com.ecommerce.ecommerceapplication.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerceapplication.dao.CategoryRepo;
import com.ecommerce.ecommerceapplication.exceptionClass.CategoryIdNotFoundException;
import com.ecommerce.ecommerceapplication.model.Category;
import com.ecommerce.ecommerceapplication.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category saveCategory(Category ca) {
        return categoryRepo.save(ca);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category updateCategory(int id, Category category) throws CategoryIdNotFoundException {

        Optional<Category> cat = categoryRepo.findById(id);
        Category ct = cat.get();
        if (cat.isPresent()) {
            ct.setCategoryName(category.getCategoryName());
            ct.setDescription(cat.get().getDescription());
            ct.setImageUrl(cat.get().getImageUrl());
            categoryRepo.save(ct);
        } else {
            throw new CategoryIdNotFoundException("Category not found with id : " + id);
        }
        return ct;
    }

}
