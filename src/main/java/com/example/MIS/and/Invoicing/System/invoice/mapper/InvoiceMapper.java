package com.example.MIS.and.Invoicing.System.invoice.mapper;

import com.example.MIS.and.Invoicing.System.invoice.dto.InvoiceResponseDTO;
import com.example.MIS.and.Invoicing.System.invoice.entity.InvoiceEntity;
import org.springframework.stereotype.Component;

@Component
public class InvoiceMapper {

    public InvoiceResponseDTO toDTO(InvoiceEntity entity) {
        InvoiceResponseDTO dto = new InvoiceResponseDTO();
        dto.setId(entity.getId());
        dto.setInvoiceNo(entity.getInvoiceNo());
        dto.setEstimatedId(entity.getEstimation().getEstimatedId());
        dto.setChainId(entity.getChain().getChainId());
        dto.setChainName(entity.getChain().getChainName());
        dto.setServiceDetails(entity.getServiceDetails());
        dto.setQty(entity.getQty());
        dto.setCostPerQty(entity.getCostPerQty());
        dto.setAmountPayable(entity.getAmountPayable());
        dto.setBalance(entity.getBalance());
        dto.setDateOfPayment(entity.getDateOfPayment());
        dto.setDateOfService(entity.getDateOfService());
        dto.setDeliveryDetails(entity.getDeliveryDetails());
        dto.setEmailId(entity.getEmailId());
        return dto;
    }
}
