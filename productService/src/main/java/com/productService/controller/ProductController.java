package com.productService.controller;

import com.productService.dto.product.ProductFilterDTO;
import com.productService.dto.product.ProductResponseDTO;
import com.productService.dto.product.ProductSaveDTO;
import com.productService.dto.product.ProductTakeDTO;
import com.productService.service.CategoryService;
import com.productService.service.ProductService;
import jakarta.validation.Valid;
import org.commonModule.helper.Logable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService category;

    @PostMapping("/save")
    @Logable(message = "Save New Product!")
    public ResponseEntity<ProductResponseDTO> save(@Valid @RequestBody ProductSaveDTO productSaveDTO) {
        return productService.save(productSaveDTO);
    }

    @PostMapping("/take")
    @Logable(message = "Take Product Quantity Product!")
    public ResponseEntity<ProductResponseDTO> take(@Valid @RequestBody ProductTakeDTO productTakeDTO) {
        return productService.take(productTakeDTO);

    }

    @PostMapping("/update")
    @Logable(message = "Add Product Quantity Product!")
    public ResponseEntity<ProductResponseDTO> update(@Valid @RequestBody ProductTakeDTO productTakeDTO) {
        return productService.update(productTakeDTO);

    }

    @PostMapping("/filter")
    @Logable(message = "Add Product Quantity Product!")
    public ResponseEntity<List<ProductResponseDTO>> filter(@Valid @RequestBody ProductFilterDTO productFilterDTO) {
        return productService.filter(productFilterDTO);
    }


}
