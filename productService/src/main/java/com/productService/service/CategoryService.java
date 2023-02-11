package com.productService.service;

import com.productService.dto.category.CategoryResponseDTO;
import com.productService.dto.category.CategorySaveDTO;
import com.productService.repository.CategoryRepository;
import org.commonModule.entity.CategoryEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public ResponseEntity<CategoryResponseDTO> save(CategorySaveDTO categorySaveDTO) {
        CategoryEntity categoryEntity = new CategoryEntity();
        BeanUtils.copyProperties(categorySaveDTO, categoryEntity);
        categoryEntity = categoryRepository.save(categoryEntity);
        return new ResponseEntity<>(convertEntityToResponse(categoryEntity), HttpStatus.OK);
    }

    private CategoryResponseDTO convertEntityToResponse(CategoryEntity categoryEntity) {
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
        BeanUtils.copyProperties(categoryEntity, categoryResponseDTO);
        return categoryResponseDTO;
    }
}
