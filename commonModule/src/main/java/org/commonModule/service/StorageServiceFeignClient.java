package org.commonModule.service;

import org.commonModule.entity.StorageEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "storage-service", url = "http://localhost:9000", path = "/storage")
public interface StorageServiceFeignClient {
    @GetMapping("/get/{id}")
    StorageEntity get(@PathVariable("id") String id);
}