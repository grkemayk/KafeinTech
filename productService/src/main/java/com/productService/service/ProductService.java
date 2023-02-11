package com.productService.service;

import com.productService.dto.product.ProductFilterDTO;
import com.productService.dto.product.ProductResponseDTO;
import com.productService.dto.product.ProductSaveDTO;
import com.productService.dto.product.ProductTakeDTO;
import com.productService.repository.CategoryRepository;
import com.productService.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.commonModule.constant.Regions;
import org.commonModule.entity.CategoryEntity;
import org.commonModule.entity.ProductEntity;
import org.commonModule.entity.StorageEntity;
import org.commonModule.service.StorageServiceFeignClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    StorageServiceFeignClient storageServiceFeignClient;

    public ResponseEntity<ProductResponseDTO> save(ProductSaveDTO productSaveDTO) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(productSaveDTO, productEntity);
        CategoryEntity categoryEntity = categoryRepository.findByCategory(productSaveDTO.getCategory()).orElseThrow(() -> new RuntimeException());
        StorageEntity storageEntity = storageServiceFeignClient.get(productSaveDTO.getStorage());
        productEntity.setCategory(categoryEntity);
        productEntity.setStorage(storageEntity);
        productEntity = productRepository.save(productEntity);
        return new ResponseEntity<>(convertEntityToResponse(productEntity), HttpStatus.OK);
    }

    public ResponseEntity<ProductResponseDTO> take(ProductTakeDTO productTakeDTO) {
        ProductEntity productEntity = productRepository.findByName(productTakeDTO.getName()).orElseThrow(() -> new RuntimeException());
        productEntity = productRepository.save(checkQuantity(productEntity, productTakeDTO.getQuantity()));
        return new ResponseEntity<>(convertEntityToResponse(productEntity), HttpStatus.OK);
    }

    public ResponseEntity<ProductResponseDTO> update(ProductTakeDTO productTakeDTO) {
        ProductEntity productEntity = productRepository.findByName(productTakeDTO.getName()).orElseThrow(() -> new RuntimeException());
        productEntity.setQuantity(productEntity.getQuantity() + productTakeDTO.getQuantity());
        productEntity = productRepository.save(productEntity);
        return new ResponseEntity<>(convertEntityToResponse(productEntity), HttpStatus.OK);
    }

    public ResponseEntity<List<ProductResponseDTO>> filter(ProductFilterDTO productFilterDTO) {
        CategoryEntity categoryEntity = (StringUtils.isEmpty(productFilterDTO.getCategory()) ? null : categoryRepository.findByCategory(productFilterDTO.getCategory()).get());
        List<ProductEntity> listProductEntity = productRepository.filterProductEntity((StringUtils.isEmpty(productFilterDTO.getRegion()) ? null : Regions.valueOf(productFilterDTO.getRegion())),
                (StringUtils.isEmpty(productFilterDTO.getCity()) ? null : productFilterDTO.getCity()),
                (StringUtils.isEmpty(productFilterDTO.getFullAddress()) ? null : productFilterDTO.getFullAddress()),
                (categoryEntity));
        List<ProductResponseDTO> listProductResponse = new ArrayList<>();
        for (ProductEntity productEntity : listProductEntity) {
            listProductResponse.add(convertEntityToResponse(productEntity));
        }
        return new ResponseEntity<>(listProductResponse, HttpStatus.OK);
    }

    private ProductEntity checkQuantity(ProductEntity productEntity, Long takeQuantity) {
        if (takeQuantity > productEntity.getQuantity())
            throw new RuntimeException();
        productEntity.setQuantity(productEntity.getQuantity() - takeQuantity);
        if (productEntity.getCriticalQuantity() >= productEntity.getQuantity())
            log.warn("Product Critical Quanatity".concat(productEntity.toString()));
        return productEntity;
    }

    private ProductResponseDTO convertEntityToResponse(ProductEntity productEntity) {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        BeanUtils.copyProperties(productEntity, productResponseDTO);
        productResponseDTO.setCategory(productEntity.getCategory().getCategory());
        productResponseDTO.setStorage(productEntity.getStorage().toString());
        return productResponseDTO;
    }

}
