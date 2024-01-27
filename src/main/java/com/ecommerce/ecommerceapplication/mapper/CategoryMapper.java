package com.ecommerce.ecommerceapplication.mapper;

import java.util.List;

import com.ecommerce.ecommerceapplication.dto.CategoryDto;
import com.ecommerce.ecommerceapplication.model.Category;

public interface CategoryMapper {

    Category saveCategory(CategoryDto category);

    CategoryDto convertoDto(Category savedCategory);

    List<CategoryDto> convertoDtoList(List<Category> c);

    Category updateCategory(int id, CategoryDto cDto);
    
}
