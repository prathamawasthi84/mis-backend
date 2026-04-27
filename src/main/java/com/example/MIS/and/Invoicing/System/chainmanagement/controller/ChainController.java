package com.example.MIS.and.Invoicing.System.chainmanagement.controller;

import com.example.MIS.and.Invoicing.System.chainmanagement.dto.ChainDTO;
import com.example.MIS.and.Invoicing.System.chainmanagement.service.ChainService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chains")
public class ChainController {

    private final ChainService chainService;

    public ChainController(ChainService chainService) {
        this.chainService = chainService;
    }

    @PostMapping
    public ResponseEntity<?> addChain(@RequestBody ChainDTO chainDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(chainService.addChain(chainDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllChains() {
        return ResponseEntity.ok(chainService.getAllChains());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateChain(@PathVariable Long id, @RequestBody ChainDTO chainDTO) {
        try {
            return ResponseEntity.ok(chainService.updateChain(id, chainDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteChain(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(chainService.deleteChain(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
