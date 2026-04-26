package com.example.MIS.and.Invoicing.System.groupmanagement.controller;

import com.example.MIS.and.Invoicing.System.groupmanagement.dto.BrandDTO;
import com.example.MIS.and.Invoicing.System.groupmanagement.service.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    public ResponseEntity<?> addBrand(@RequestBody BrandDTO brandDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(brandService.addBrand(brandDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllBrands() {
        return ResponseEntity.ok(brandService.getAllBrands());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBrand(@PathVariable Long id, @RequestBody BrandDTO brandDTO) {
        try {
            return ResponseEntity.ok(brandService.updateBrand(id, brandDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(brandService.deleteBrand(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
