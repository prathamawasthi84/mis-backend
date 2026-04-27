package com.example.MIS.and.Invoicing.System.zonemanagement.service;

import com.example.MIS.and.Invoicing.System.brandmanagement.entity.BrandEntity;
import com.example.MIS.and.Invoicing.System.brandmanagement.repository.BrandRepository;
import com.example.MIS.and.Invoicing.System.zonemanagement.dto.ZoneRequestDTO;
import com.example.MIS.and.Invoicing.System.zonemanagement.dto.ZoneResponseDTO;
import com.example.MIS.and.Invoicing.System.zonemanagement.entity.ZoneEntity;
import com.example.MIS.and.Invoicing.System.zonemanagement.mapper.ZoneMapper;
import com.example.MIS.and.Invoicing.System.zonemanagement.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZoneService {

    @Autowired
    private ZoneRepository zoneRepository;
    @Autowired private BrandRepository brandRepository;
    @Autowired private ZoneMapper zoneMapper;

    public List<ZoneResponseDTO> getAllZones() {
        return zoneRepository.findByIsActiveTrue()
                .stream()
                .map(zoneMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public ZoneResponseDTO addZone(ZoneRequestDTO dto) {
        BrandEntity brand = brandRepository.findById(dto.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));

        if (zoneRepository.existsByZoneNameIgnoreCaseAndIsActiveTrue(dto.getZoneName().trim()))
            throw new RuntimeException("Zone already exists");

        ZoneEntity saved = zoneRepository.save(zoneMapper.toEntity(dto, brand));
        return zoneMapper.toResponseDTO(saved);
    }

    public ZoneResponseDTO updateZone(Integer id, ZoneRequestDTO dto) {
        ZoneEntity zone = zoneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Zone not found"));

        BrandEntity brand = brandRepository.findById(dto.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));

        zone.setZoneName(dto.getZoneName().trim());
        zone.setBrand(brand);
        return zoneMapper.toResponseDTO(zoneRepository.save(zone));
    }

    public void deleteZone(Integer id) {
        ZoneEntity zone = zoneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Zone not found"));
        zone.setIsActive(false);
        zoneRepository.save(zone);
    }
}