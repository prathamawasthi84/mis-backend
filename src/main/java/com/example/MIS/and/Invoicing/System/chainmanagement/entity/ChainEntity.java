package com.example.MIS.and.Invoicing.System.chainmanagement.entity;

import com.example.MIS.and.Invoicing.System.groupmanagement.entity.CustomerGroupEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "chains")
public class ChainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer chainId;

    @Column(nullable = false)
    private String chainName;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private CustomerGroupEntity group;

    @Column(nullable = false)
    private boolean isActive = true;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() { this.createdAt = LocalDateTime.now(); }

    @PreUpdate
    public void onUpdate() { this.updatedAt = LocalDateTime.now(); }

    // getters and setters

    public Integer getChainId() {
        return chainId;
    }

    public String getChainName() {
        return chainName;
    }

    public CustomerGroupEntity getGroup() {
        return group;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }


    public void setChainId(Integer chainId) {
        this.chainId = chainId;
    }

    public void setChainName(String chainName) {
        this.chainName = chainName;
    }

    public void setGroup(CustomerGroupEntity group) {
        this.group = group;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}