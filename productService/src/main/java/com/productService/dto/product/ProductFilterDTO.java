package com.productService.dto.product;

import lombok.Data;

@Data
public class ProductFilterDTO {
    private String region;
    private String city;
    private String fullAddress;
    private String category;
}
