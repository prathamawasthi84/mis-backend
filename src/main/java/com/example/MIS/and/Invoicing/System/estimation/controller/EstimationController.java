package com.example.MIS.and.Invoicing.System.estimation.controller;

import com.example.MIS.and.Invoicing.System.estimation.dto.EstimationRequestDTO;
import com.example.MIS.and.Invoicing.System.estimation.dto.EstimationResponseDTO;
import com.example.MIS.and.Invoicing.System.estimation.service.EstimationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estimations")
public class EstimationController {

    @Autowired
    private EstimationService estimationService;

    @GetMapping
    public ResponseEntity<List<EstimationResponseDTO>> getAllEstimations() {
        return ResponseEntity.ok(estimationService.getAllEstimations());
    }

    @PostMapping
    public ResponseEntity<EstimationResponseDTO> addEstimation(
            @Valid @RequestBody EstimationRequestDTO dto) {
        return ResponseEntity.ok(estimationService.addEstimation(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstimationResponseDTO> updateEstimation(
            @PathVariable Integer id,
            @Valid @RequestBody EstimationRequestDTO dto) {
        return ResponseEntity.ok(estimationService.updateEstimation(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstimation(@PathVariable Integer id) {
        estimationService.deleteEstimation(id);
        return ResponseEntity.noContent().build();
    }
}