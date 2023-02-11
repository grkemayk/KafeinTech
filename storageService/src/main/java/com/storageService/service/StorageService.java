package com.storageService.service;

import com.storageService.dto.StorageResponseDTO;
import com.storageService.dto.StorageSaveDTO;
import com.storageService.repository.StorageRepository;
import org.commonModule.constant.StorageAddress;
import org.commonModule.entity.StorageEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StorageService {

    @Autowired
    StorageRepository storageRepository;

    public ResponseEntity<StorageResponseDTO> save(StorageSaveDTO storageSaveDTO) {
        StorageEntity storageEntity = new StorageEntity();
        StorageAddress storageAddress = new StorageAddress(storageSaveDTO.getFullAddress(), storageSaveDTO.getRegion(), storageSaveDTO.getCity());
        storageEntity.setAddress(storageAddress);
        storageEntity = storageRepository.save(storageEntity);
        return new ResponseEntity<>(convertEntityToResponse(storageEntity), HttpStatus.OK);
    }

    public StorageEntity get(String id) {
        return storageRepository.findById(Long.valueOf(id)).orElseThrow(() -> new RuntimeException());
    }

    private StorageResponseDTO convertEntityToResponse(StorageEntity storageEntity) {
        StorageResponseDTO storageResponseDTO = new StorageResponseDTO();
        BeanUtils.copyProperties(storageEntity, storageResponseDTO);
        storageResponseDTO.setRegion(storageEntity.getAddress().getRegion().name());
        storageResponseDTO.setCity(storageEntity.getAddress().getCity());
        storageResponseDTO.setFullAddress(storageEntity.getAddress().getFullAddress());
        return storageResponseDTO;
    }
}
