package com.ecommerce.ecommerceapplication.mapper.Impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.ecommerce.ecommerceapplication.dto.CategoryDto;
import com.ecommerce.ecommerceapplication.mapper.CategoryMapper;
import com.ecommerce.ecommerceapplication.model.Category;

@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category saveCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setCategoryName(categoryDto.getCategoryName());
        category.setDescription(categoryDto.getDescription());
        category.setImageUrl(categoryDto.getImageUrl());
        return category;
    }

    @Override
    public CategoryDto convertoDto(Category savedCategory) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryName(savedCategory.getCategoryName());
        categoryDto.setDescription(savedCategory.getDescription());
        categoryDto.setImageUrl(savedCategory.getImageUrl());
        categoryDto.setId(savedCategory.getId());
        return categoryDto;
    }

    @Override
    public List<CategoryDto> convertoDtoList(List<Category> c) {
        List<CategoryDto> result = new ArrayList<>();
        c.forEach(category -> {
            CategoryDto dtoList = convertoDto(category);
            result.add(dtoList);
        });
        return result;
    }

    @Override
    public Category updateCategory(int id, CategoryDto cDto) {
        Category cat = new Category();
        cat.setCategoryName(cDto.getCategoryName());
        cat.setDescription(cDto.getDescription());
        cat.setImageUrl(cDto.getImageUrl());
        return cat;
    }

}
