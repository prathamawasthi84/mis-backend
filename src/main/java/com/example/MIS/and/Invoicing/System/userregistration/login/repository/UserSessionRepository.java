package com.example.MIS.and.Invoicing.System.userregistration.login.repository;

import com.example.MIS.and.Invoicing.System.userregistration.login.SessionStatus;
import com.example.MIS.and.Invoicing.System.userregistration.login.entity.UserEntity;
import com.example.MIS.and.Invoicing.System.userregistration.login.entity.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserSessionRepository extends JpaRepository<UserSession,Integer> {
    Optional<UserSession> findByToken(String token);
    Optional<UserSession> findByUserEntityAndSessionStatus(UserEntity userEntity, SessionStatus sessionStatus);
}
