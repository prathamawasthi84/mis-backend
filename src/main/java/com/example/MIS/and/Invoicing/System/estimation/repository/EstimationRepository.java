package com.example.MIS.and.Invoicing.System.estimation.repository;

import com.example.MIS.and.Invoicing.System.estimation.entity.EstimationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstimationRepository extends JpaRepository<EstimationEntity, Integer> {
    List<EstimationEntity> findByChain_ChainId(Integer chainId);
}
