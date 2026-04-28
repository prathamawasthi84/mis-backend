package com.example.MIS.and.Invoicing.System.estimation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class EstimationRequestDTO {

    @NotNull
    private Integer chainId;

    @NotBlank
    private String groupName;

    @NotBlank
    private String brandName;

    @NotBlank
    private String zoneName;

    @NotBlank
    private String service;

    @NotNull
    private Integer qty;

    @NotNull
    private Float costPerUnit;

    @NotNull
    private Float totalCost;

    @NotNull
    private LocalDate deliveryDate;

    private String deliveryDetails;

    // getters

    public String getDeliveryDetails() {
        return deliveryDetails;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public Float getTotalCost() {
        return totalCost;
    }

    public Float getCostPerUnit() {
        return costPerUnit;
    }

    public String getService() {
        return service;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getZoneName() {
        return zoneName;
    }

    public String getBrandName() {
        return brandName;
    }

    public Integer getQty() {
        return qty;
    }

    public Integer getChainId() {
        return chainId;
    }
    //Setters

    public void setTotalCost(Float totalCost) {
        this.totalCost = totalCost;
    }

    public void setDeliveryDetails(String deliveryDetails) {
        this.deliveryDetails = deliveryDetails;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setCostPerUnit(Float costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public void setChainId(Integer chainId) {
        this.chainId = chainId;
    }
}
