package com.ecommerce.ecommerceapplication.dto;

import java.util.List;

import com.ecommerce.ecommerceapplication.model.Category;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private int Id;
    @NotNull
    private String productName;

    @NotNull
    private String description;

    @NotNull
    private int price;

    @NotNull
    private String imageUrl;

    @NotNull
    private Integer categoryId;

    @NotNull
    private int quantity;

    private List<Category> categories;

}
