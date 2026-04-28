package com.example.MIS.and.Invoicing.System.estimation.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EstimationResponseDTO {

    private Integer estimatedId;
    private Integer chainId;
    private String chainName;   // pulled from ChainEntity
    private String groupName;
    private String brandName;
    private String zoneName;
    private String service;
    private Integer qty;
    private Float costPerUnit;
    private Float totalCost;
    private LocalDate deliveryDate;
    private String deliveryDetails;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

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

    public Integer getChainId() {
        return chainId;
    }

    public String getService() {
        return service;
    }

    public Float getCostPerUnit() {
        return costPerUnit;
    }

    public Float getTotalCost() {
        return totalCost;
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

    public Integer getEstimatedId() {
        return estimatedId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getChainName() {
        return chainName;
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

    public void setCostPerUnit(Float costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public void setChainId(Integer chainId) {
        this.chainId = chainId;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setDeliveryDetails(String deliveryDetails) {
        this.deliveryDetails = deliveryDetails;
    }

    public void setTotalCost(Float totalCost) {
        this.totalCost = totalCost;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public void setEstimatedId(Integer estimatedId) {
        this.estimatedId = estimatedId;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setChainName(String chainName) {
        this.chainName = chainName;
    }
}
