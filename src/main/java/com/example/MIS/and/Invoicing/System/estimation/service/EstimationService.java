package com.example.MIS.and.Invoicing.System.estimation.service;

import com.example.MIS.and.Invoicing.System.chainmanagement.entity.ChainEntity;
import com.example.MIS.and.Invoicing.System.chainmanagement.repository.ChainRepository;
import com.example.MIS.and.Invoicing.System.estimation.dto.EstimationRequestDTO;
import com.example.MIS.and.Invoicing.System.estimation.dto.EstimationResponseDTO;
import com.example.MIS.and.Invoicing.System.estimation.entity.EstimationEntity;
import com.example.MIS.and.Invoicing.System.estimation.mapper.EstimationMapper;
import com.example.MIS.and.Invoicing.System.estimation.repository.EstimationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstimationService {

    @Autowired
    private EstimationRepository estimationRepository;

    @Autowired
    private ChainRepository chainRepository;

    public List<EstimationResponseDTO> getAllEstimations() {
        return estimationRepository.findAll()
                .stream()
                .map(EstimationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EstimationResponseDTO addEstimation(EstimationRequestDTO dto) {
        ChainEntity chain = chainRepository.findById(Long.valueOf(dto.getChainId()))
                .orElseThrow(() -> new RuntimeException("Chain not found"));

        EstimationEntity entity = new EstimationEntity();
        entity.setChain(chain);
        entity.setGroupName(dto.getGroupName());
        entity.setBrandName(dto.getBrandName());
        entity.setZoneName(dto.getZoneName());
        entity.setService(dto.getService());
        entity.setQty(dto.getQty());
        entity.setCostPerUnit(dto.getCostPerUnit());
        entity.setTotalCost(dto.getTotalCost());
        entity.setDeliveryDate(dto.getDeliveryDate());
        entity.setDeliveryDetails(dto.getDeliveryDetails());

        return EstimationMapper.toDTO(estimationRepository.save(entity));
    }

    public EstimationResponseDTO updateEstimation(Integer id, EstimationRequestDTO dto) {
        EstimationEntity entity = estimationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estimation not found"));

        ChainEntity chain = chainRepository.findById(Long.valueOf(dto.getChainId()))
                .orElseThrow(() -> new RuntimeException("Chain not found"));

        entity.setChain(chain);
        entity.setGroupName(dto.getGroupName());
        entity.setBrandName(dto.getBrandName());
        entity.setZoneName(dto.getZoneName());
        entity.setService(dto.getService());
        entity.setQty(dto.getQty());
        entity.setCostPerUnit(dto.getCostPerUnit());
        entity.setTotalCost(dto.getTotalCost());
        entity.setDeliveryDate(dto.getDeliveryDate());
        entity.setDeliveryDetails(dto.getDeliveryDetails());

        return EstimationMapper.toDTO(estimationRepository.save(entity));
    }

    public void deleteEstimation(Integer id) {
        EstimationEntity entity = estimationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estimation not found"));
        estimationRepository.delete(entity);
    }
}
