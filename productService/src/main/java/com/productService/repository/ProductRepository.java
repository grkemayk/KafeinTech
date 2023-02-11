package com.productService.repository;

import org.commonModule.constant.Regions;
import org.commonModule.entity.CategoryEntity;
import org.commonModule.entity.ProductEntity;
import org.commonModule.entity.StorageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findByName(String name);


    Optional<List<ProductEntity>> findByStorage(StorageEntity storageEntity);

    @Query(value = "SELECT u from ProductEntity u where (:region is null or u.storage.address.region = :region) and (:city is null or u.storage.address.city = :city) and (:fullAddress is null or u.storage.address.fullAddress = :fullAddress) and (:category is null or u.category = :category)")
    List<ProductEntity> filterProductEntity(@Param("region") Regions region, @Param("city") String city, @Param("fullAddress") String fullAddress, @Param("category") CategoryEntity category);
}
