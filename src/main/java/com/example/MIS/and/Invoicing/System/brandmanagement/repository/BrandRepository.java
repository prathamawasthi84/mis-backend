package com.example.MIS.and.Invoicing.System.brandmanagement.repository;

import com.example.MIS.and.Invoicing.System.brandmanagement.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Integer> {
    boolean existsByBrandNameAndIsActiveTrue(String brandName);
    List<BrandEntity> findAllByIsActiveTrue();
}