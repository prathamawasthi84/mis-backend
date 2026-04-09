package com.example.MIS.and.Invoicing.System.userregistration.login.entity;

import com.example.MIS.and.Invoicing.System.userregistration.login.SessionStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_sessions")
public class UserSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sessionId;
    @Column(name = "token", length = 512)
    private String token;
    @Enumerated(EnumType.STRING)
    @Column(name = "session_status")
    private SessionStatus sessionStatus;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public UserSession(){

    }
    public UserSession(Integer sessionId,String token,SessionStatus sessionStatus,LocalDateTime createdAt,LocalDateTime expiresAt){
        this.sessionId=sessionId;
        this.token=token;
        this.sessionStatus=sessionStatus;
        this.createdAt=createdAt;
        this.expiresAt=expiresAt;
    }
    //Getters

    public Integer getSessionId() {
        return sessionId;
    }

    public String getToken() {
        return token;
    }
    public SessionStatus getSessionStatus() {
        return sessionStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }
    //Setters

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setSessionStatus(SessionStatus sessionStatus) {
        this.sessionStatus = sessionStatus;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
