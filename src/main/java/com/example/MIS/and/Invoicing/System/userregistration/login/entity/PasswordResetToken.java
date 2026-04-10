package com.example.MIS.and.Invoicing.System.userregistration.login.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "password_reset_tokens")
public class PasswordResetToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "token", nullable = false)
    private String token;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @Column(name = "expires_at")
    private LocalDateTime expiresAt;

    @Column(name = "used")
    private boolean used = false;

    public PasswordResetToken (){

    }
    //Getters

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }
    public boolean isUsed(){
        return used;
    }
    //Setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}
