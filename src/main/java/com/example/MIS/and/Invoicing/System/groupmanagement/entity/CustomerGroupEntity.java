package com.example.MIS.and.Invoicing.System.groupmanagement.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer_groups")
    public class CustomerGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer groupId;
    @Column(name = "group_name", unique = true, nullable = false)
    private String groupName;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
    public CustomerGroupEntity(){

    }
    public CustomerGroupEntity(Integer groupId,String groupName ,Boolean isActive){
        this.groupId=groupId;
        this.groupName=groupName;
        this.isActive=isActive;
    }
    //Getters
    public Integer getGroupId() {
        return groupId;
    }
    public String getGroupName() {
        return groupName;
    }
    public Boolean getIsActive() {
        return isActive;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    //Setters
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
