package com.productService.dto.product;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private String name;
    private String category;
    private String storage;
    private Long quantity;
    private Long criticalQuantity;
}
