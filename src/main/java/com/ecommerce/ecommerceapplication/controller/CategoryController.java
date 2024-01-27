package com.ecommerce.ecommerceapplication.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.ecommerceapplication.dto.CategoryDto;
import com.ecommerce.ecommerceapplication.exceptionClass.CategoryIdNotFoundException;
import com.ecommerce.ecommerceapplication.mapper.CategoryMapper;
import com.ecommerce.ecommerceapplication.model.Category;
import com.ecommerce.ecommerceapplication.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @PostMapping("/save")
    public ResponseEntity<CategoryDto> saveCategory(@Valid @RequestBody CategoryDto category) {
        Category ca = categoryMapper.saveCategory(category);
        Category savedCategory = categoryService.saveCategory(ca);
        CategoryDto cDto = categoryMapper.convertoDto(savedCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(cDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryDto>> getAll() {
        List<Category> c = categoryService.getAll();
        List<CategoryDto> cDto = categoryMapper.convertoDtoList(c);
        return ResponseEntity.status(HttpStatus.OK).body(cDto);
    }

    @PostMapping("updateCategory/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable int id, @RequestBody CategoryDto cDto)
            throws CategoryIdNotFoundException {
        Category category = categoryMapper.updateCategory(id, cDto);
        Category updatedcCategory = categoryService.updateCategory(id, category);
        CategoryDto updatedcCategoryDto = categoryMapper.convertoDto(updatedcCategory);
        return ResponseEntity.status(HttpStatus.OK).body(updatedcCategoryDto);
    }

}
