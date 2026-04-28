package com.example.MIS.and.Invoicing.System.invoice.controller;

import com.example.MIS.and.Invoicing.System.invoice.dto.InvoiceRequestDTO;
import com.example.MIS.and.Invoicing.System.invoice.dto.InvoiceResponseDTO;
import com.example.MIS.and.Invoicing.System.invoice.service.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public ResponseEntity<List<InvoiceResponseDTO>> getAll(
            @RequestParam(required = false) String search) {
        if (search != null && !search.isBlank()) {
            return ResponseEntity.ok(invoiceService.searchInvoices(search));
        }
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }

    @PostMapping
    public ResponseEntity<InvoiceResponseDTO> create(@Valid @RequestBody InvoiceRequestDTO dto) {
        return ResponseEntity.ok(invoiceService.createInvoice(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceResponseDTO> update(
            @PathVariable Integer id,
            @RequestParam String emailId) {
        return ResponseEntity.ok(invoiceService.updateInvoice(id, emailId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }
}
