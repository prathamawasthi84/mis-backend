package com.example.MIS.and.Invoicing.System.zonemanagement.controller;

import com.example.MIS.and.Invoicing.System.zonemanagement.dto.ZoneRequestDTO;
import com.example.MIS.and.Invoicing.System.zonemanagement.dto.ZoneResponseDTO;
import com.example.MIS.and.Invoicing.System.zonemanagement.service.ZoneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zones")
public class ZoneController {

    @Autowired
    private ZoneService zoneService;

    @GetMapping
    public ResponseEntity<List<ZoneResponseDTO>> getAllZones() {
        return ResponseEntity.ok(zoneService.getAllZones());
    }

    @PostMapping
    public ResponseEntity<ZoneResponseDTO> addZone(@Valid @RequestBody ZoneRequestDTO dto) {
        return ResponseEntity.ok(zoneService.addZone(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ZoneResponseDTO> updateZone(
            @PathVariable Integer id,
            @Valid @RequestBody ZoneRequestDTO dto) {
        return ResponseEntity.ok(zoneService.updateZone(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZone(@PathVariable Integer id) {
        zoneService.deleteZone(id);
        return ResponseEntity.noContent().build();
    }
}