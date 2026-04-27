package com.example.MIS.and.Invoicing.System.chainmanagement.repository;

import com.example.MIS.and.Invoicing.System.chainmanagement.entity.ChainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChainRepository extends JpaRepository<ChainEntity, Long> {
    boolean existsByChainNameAndIsActiveTrue(String chainName);
    List<ChainEntity> findAllByIsActiveTrue();
}
