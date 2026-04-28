package com.example.MIS.and.Invoicing.System.estimation.entity;

import com.example.MIS.and.Invoicing.System.chainmanagement.entity.ChainEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "estimation")
public class EstimationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer estimatedId;

    @ManyToOne
    @JoinColumn(name = "chain_id", nullable = false)
    private ChainEntity chain;

    private String groupName;
    private String brandName;
    private String zoneName;

    @Column(length = 100)
    private String service;

    private Integer qty;
    private Float costPerUnit;
    private Float totalCost;
    private LocalDate deliveryDate;

    @Column(length = 100)
    private String deliveryDetails;

    private LocalDateTime createdAt;
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

    // getters

    public String getBrandName() {
        return brandName;
    }

    public String getZoneName() {
        return zoneName;
    }

    public String getGroupName() {
        return groupName;
    }

    public ChainEntity getChain() {
        return chain;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Float getCostPerUnit() {
        return costPerUnit;
    }

    public Float getTotalCost() {
        return totalCost;
    }

    public Integer getEstimatedId() {
        return estimatedId;
    }

    public Integer getQty() {
        return qty;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public String getDeliveryDetails() {
        return deliveryDetails;
    }

    public String getService() {
        return service;
    }
    //Setters

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setChain(ChainEntity chain) {
        this.chain = chain;
    }

    public void setCostPerUnit(Float costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setEstimatedId(Integer estimatedId) {
        this.estimatedId = estimatedId;
    }

    public void setDeliveryDetails(String deliveryDetails) {
        this.deliveryDetails = deliveryDetails;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setTotalCost(Float totalCost) {
        this.totalCost = totalCost;
    }
}