package com.productService.dto.product;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductTakeDTO {
    @NotNull(message = "Name Cannot Be Empty!")
    private String name;
    @NotNull(message = "Quantity Cannot Be Empty!")
    private Long quantity;
}
