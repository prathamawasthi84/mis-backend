package com.example.MIS.and.Invoicing.System.groupmanagement.repository;

import com.example.MIS.and.Invoicing.System.groupmanagement.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
    boolean existsByBrandNameAndIsActiveTrue(String brandName);
    List<BrandEntity> findAllByIsActiveTrue();
}