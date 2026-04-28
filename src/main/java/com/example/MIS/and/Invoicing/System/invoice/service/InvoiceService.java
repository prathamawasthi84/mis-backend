package com.example.MIS.and.Invoicing.System.invoice.service;

import com.example.MIS.and.Invoicing.System.chainmanagement.entity.ChainEntity;
import com.example.MIS.and.Invoicing.System.chainmanagement.repository.ChainRepository;
import com.example.MIS.and.Invoicing.System.estimation.entity.EstimationEntity;
import com.example.MIS.and.Invoicing.System.estimation.repository.EstimationRepository;
import com.example.MIS.and.Invoicing.System.invoice.dto.InvoiceRequestDTO;
import com.example.MIS.and.Invoicing.System.invoice.dto.InvoiceResponseDTO;
import com.example.MIS.and.Invoicing.System.invoice.entity.InvoiceEntity;
import com.example.MIS.and.Invoicing.System.invoice.mapper.InvoiceMapper;
import com.example.MIS.and.Invoicing.System.invoice.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired private EstimationRepository estimationRepository;
    @Autowired private ChainRepository chainRepository;
    @Autowired private InvoiceMapper invoiceMapper;

    // Auto-generate unique 4-digit invoice number
    private Integer generateInvoiceNo() {
        Random random = new Random();
        Integer no;
        do {
            no = 1000 + random.nextInt(9000); // 1000–9999
        } while (invoiceRepository.existsByInvoiceNo(no));
        return no;
    }

    public List<InvoiceResponseDTO> getAllInvoices() {
        return invoiceRepository.findAll()
                .stream().map(invoiceMapper::toDTO).toList();
    }

    public List<InvoiceResponseDTO> searchInvoices(String keyword) {
        return invoiceRepository.searchInvoices(keyword)
                .stream().map(invoiceMapper::toDTO).toList();
    }

    public InvoiceResponseDTO createInvoice(InvoiceRequestDTO dto) {
        EstimationEntity estimation = estimationRepository.findById(dto.getEstimatedId())
                .orElseThrow(() -> new RuntimeException("Estimation not found"));
        ChainEntity chain = chainRepository.findById(Long.valueOf(dto.getChainId()))
                .orElseThrow(() -> new RuntimeException("Chain not found"));

        InvoiceEntity entity = new InvoiceEntity();
        entity.setInvoiceNo(generateInvoiceNo());
        entity.setEstimation(estimation);
        entity.setChain(chain);
        entity.setServiceDetails(dto.getServiceDetails());
        entity.setQty(dto.getQty());
        entity.setCostPerQty(dto.getCostPerQty());
        entity.setAmountPayable(dto.getAmountPayable());
        entity.setBalance(dto.getBalance());
        entity.setDateOfPayment(dto.getDateOfPayment());
        entity.setDateOfService(dto.getDateOfService());
        entity.setDeliveryDetails(dto.getDeliveryDetails());
        entity.setEmailId(dto.getEmailId());

        return invoiceMapper.toDTO(invoiceRepository.save(entity));
    }

    // Only email is updatable per spec
    public InvoiceResponseDTO updateInvoice(Integer id, String emailId) {
        InvoiceEntity entity = invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
        entity.setEmailId(emailId);
        return invoiceMapper.toDTO(invoiceRepository.save(entity));
    }

    public void deleteInvoice(Integer id) {
        invoiceRepository.deleteById(id);
    }
}