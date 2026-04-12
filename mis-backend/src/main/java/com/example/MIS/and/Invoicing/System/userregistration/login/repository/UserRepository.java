package com.example.MIS.and.Invoicing.System.userregistration.login.repository;

import com.example.MIS.and.Invoicing.System.userregistration.login.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    Optional<UserEntity> findByEmail(String email);
    boolean existsByEmail(String email);
}
