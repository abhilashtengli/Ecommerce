package com.ecommerce.ecommerceapplication.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {

    @NotNull
    private int id;

    @NotNull
    private int userId;

    private LocalDate createdDate;

    @NotNull
    private int productId;

    @NotNull
    private int quantity;
}
