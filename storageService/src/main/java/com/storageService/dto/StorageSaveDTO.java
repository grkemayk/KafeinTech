package com.storageService.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StorageSaveDTO {
    @NotNull(message = "Region Cannot Be Empty!")
    private String region;
    @NotNull(message = "City Cannot Be Empty!")
    private String city;
    @NotNull(message = "Address Cannot Be Empty!")
    private String fullAddress;
}
