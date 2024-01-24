package com.ecommerce.ecommerceapplication.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerceapplication.dao.CategoryRepo;
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

}
