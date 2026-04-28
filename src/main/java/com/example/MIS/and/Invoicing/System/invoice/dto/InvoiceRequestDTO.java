package com.example.MIS.and.Invoicing.System.invoice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class InvoiceRequestDTO {

    @NotNull
    private Integer estimatedId;

    @NotNull
    private Integer chainId;

    private String serviceDetails;
    private Integer qty;
    private Float costPerQty;
    private Float amountPayable;
    private Float balance;
    private LocalDateTime dateOfPayment;
    private LocalDate dateOfService;
    private String deliveryDetails;

    @Email
    private String emailId;

    //Getters

    public String getEmailId() {
        return emailId;
    }

    public String getServiceDetails() {
        return serviceDetails;
    }

    public LocalDateTime getDateOfPayment() {
        return dateOfPayment;
    }

    public LocalDate getDateOfService() {
        return dateOfService;
    }

    public Float getBalance() {
        return balance;
    }

    public Float getCostPerQty() {
        return costPerQty;
    }

    public Float getAmountPayable() {
        return amountPayable;
    }

    public String getDeliveryDetails() {
        return deliveryDetails;
    }

    public Integer getQty() {
        return qty;
    }

    public Integer getEstimatedId() {
        return estimatedId;
    }

    public Integer getChainId() {
        return chainId;
    }
    //Setters

    public void setServiceDetails(String serviceDetails) {
        this.serviceDetails = serviceDetails;
    }

    public void setDateOfService(LocalDate dateOfService) {
        this.dateOfService = dateOfService;
    }

    public void setDateOfPayment(LocalDateTime dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public void setCostPerQty(Float costPerQty) {
        this.costPerQty = costPerQty;
    }

    public void setAmountPayable(Float amountPayable) {
        this.amountPayable = amountPayable;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setDeliveryDetails(String deliveryDetails) {
        this.deliveryDetails = deliveryDetails;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public void setEstimatedId(Integer estimatedId) {
        this.estimatedId = estimatedId;
    }

    public void setChainId(Integer chainId) {
        this.chainId = chainId;
    }
}
