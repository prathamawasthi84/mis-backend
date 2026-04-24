package com.example.MIS.and.Invoicing.System.groupmanagement.repository;

import com.example.MIS.and.Invoicing.System.groupmanagement.entity.CustomerGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerGroupRepository extends JpaRepository<CustomerGroupEntity,Integer> {
    Optional<CustomerGroupEntity> findByGroupName(String groupName);
    List<CustomerGroupEntity> findByIsActiveTrue();
}
