package com.productService.dto.product;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductSaveDTO {
    @NotNull(message = "Product Name Cannot Be Empty!")
    private String name;
    @NotNull(message = "Category Cannot Be Empty!")
    private String category;
    @NotNull(message = "Storage Cannot Be Empty!")
    private String storage;
    @NotNull(message = "Quantity Cannot Be Empty")
    private Long quantity;
    @NotNull(message = "Critical Quantity Cannot Be Empty")
    private Long criticalQuantity;
}
