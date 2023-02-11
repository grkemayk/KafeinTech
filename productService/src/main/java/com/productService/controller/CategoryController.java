package com.productService.controller;

import com.productService.dto.category.CategoryResponseDTO;
import com.productService.dto.category.CategorySaveDTO;
import com.productService.service.CategoryService;
import jakarta.validation.Valid;
import org.commonModule.helper.Logable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/save")
    @Logable(message = "Add New Category!")
    public ResponseEntity<CategoryResponseDTO> save(@Valid @RequestBody CategorySaveDTO categorySaveDTO) {
        return categoryService.save(categorySaveDTO);
    }
}
