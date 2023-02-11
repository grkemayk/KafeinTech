package com.storageService.controller;

import com.storageService.dto.StorageResponseDTO;
import com.storageService.dto.StorageSaveDTO;
import com.storageService.service.StorageService;
import jakarta.validation.Valid;
import org.commonModule.entity.StorageEntity;
import org.commonModule.helper.Logable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/storage")
public class StorageController {
    @Autowired
    StorageService storageService;

    @PostMapping("/save")
    @Logable(message = "Add New Storage!")
    public ResponseEntity<StorageResponseDTO> save(@Valid @RequestBody StorageSaveDTO storageSaveDTO) {
        return storageService.save(storageSaveDTO);
    }

    @GetMapping("/get/{id}")
    public StorageEntity get(@PathVariable("id") String id) {
        return storageService.get(id);
    }
}
