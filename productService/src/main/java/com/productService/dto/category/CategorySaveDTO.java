package com.productService.dto.category;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategorySaveDTO {
    @NotNull(message = "Category Name Cannot Be Empty!")
    @Size(min = 1, max = 300, message = "Category Name Should Be Between 1 - 300 Characters!")
    private String category;
}
