package com.ecommerce.ecommerceapplication.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private int id;

    @NotNull
    @Column(unique = true)
    private @NotBlank String categoryName;

    @NotNull
    private @NotBlank String description;

    @NotNull
    @Column(unique = true)
    private @NotBlank String imageUrl;

}
