package com.example.MIS.and.Invoicing.System.zonemanagement.repository;

import com.example.MIS.and.Invoicing.System.zonemanagement.entity.ZoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZoneRepository extends JpaRepository<ZoneEntity, Integer> {

    List<ZoneEntity> findByIsActiveTrue();

    boolean existsByZoneNameIgnoreCaseAndIsActiveTrue(String zoneName);
}