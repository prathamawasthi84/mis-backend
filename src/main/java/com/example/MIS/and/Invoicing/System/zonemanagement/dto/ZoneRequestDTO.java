package com.example.MIS.and.Invoicing.System.zonemanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ZoneRequestDTO {
    @NotBlank(message = "Zone name is required")
    @Size(max = 50)
    private String zoneName;

    @NotNull(message = "Brand is required")
    private Integer brandId;

    //Getters


    public String getZoneName() {
        return zoneName;
    }

    public Integer getBrandId() {
        return brandId;
    }
}