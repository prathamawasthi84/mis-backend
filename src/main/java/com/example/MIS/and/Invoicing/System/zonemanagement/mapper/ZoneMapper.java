package com.example.MIS.and.Invoicing.System.zonemanagement.mapper;

import com.example.MIS.and.Invoicing.System.brandmanagement.entity.BrandEntity;
import com.example.MIS.and.Invoicing.System.zonemanagement.dto.ZoneRequestDTO;
import com.example.MIS.and.Invoicing.System.zonemanagement.dto.ZoneResponseDTO;
import com.example.MIS.and.Invoicing.System.zonemanagement.entity.ZoneEntity;
import org.springframework.stereotype.Component;

@Component
public class ZoneMapper {

    public ZoneResponseDTO toResponseDTO(ZoneEntity zone) {
        ZoneResponseDTO dto = new ZoneResponseDTO();
        dto.setZoneId(zone.getZoneId());
        dto.setZoneName(zone.getZoneName());
        dto.setBrandName(zone.getBrand().getBrandName());
        dto.setCompanyName(zone.getBrand().getChain().getChainName());  // chain = company
        dto.setGroupName(zone.getBrand().getChain().getGroup().getGroupName());
        return dto;
    }

    public ZoneEntity toEntity(ZoneRequestDTO dto, BrandEntity brand) {
        ZoneEntity zone = new ZoneEntity();
        zone.setZoneName(dto.getZoneName().trim());
        zone.setBrand(brand);
        return zone;
    }
}