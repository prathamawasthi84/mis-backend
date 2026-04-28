package com.example.MIS.and.Invoicing.System.estimation.mapper;

import com.example.MIS.and.Invoicing.System.estimation.dto.EstimationResponseDTO;
import com.example.MIS.and.Invoicing.System.estimation.entity.EstimationEntity;

public class EstimationMapper {

    public static EstimationResponseDTO toDTO(EstimationEntity entity) {
        EstimationResponseDTO dto = new EstimationResponseDTO();
        dto.setEstimatedId(entity.getEstimatedId());
        dto.setChainId(entity.getChain().getChainId());
        dto.setChainName(entity.getChain().getChainName()); // adjust to your ChainEntity field name
        dto.setGroupName(entity.getGroupName());
        dto.setBrandName(entity.getBrandName());
        dto.setZoneName(entity.getZoneName());
        dto.setService(entity.getService());
        dto.setQty(entity.getQty());
        dto.setCostPerUnit(entity.getCostPerUnit());
        dto.setTotalCost(entity.getTotalCost());
        dto.setDeliveryDate(entity.getDeliveryDate());
        dto.setDeliveryDetails(entity.getDeliveryDetails());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}
