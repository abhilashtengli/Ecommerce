package com.ecommerce.ecommerceapplication.service;

import java.util.List;

import com.ecommerce.ecommerceapplication.exceptionClass.CategoryIdNotFoundException;
import com.ecommerce.ecommerceapplication.model.Category;

public interface CategoryService {

    Category saveCategory(Category ca);

    List<Category> getAll();

    Category updateCategory(int id, Category category) throws CategoryIdNotFoundException;

}
