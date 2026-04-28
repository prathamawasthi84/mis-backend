package com.example.MIS.and.Invoicing.System.invoice.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class InvoiceResponseDTO {
    private Integer id;
    private Integer invoiceNo;
    private Integer estimatedId;
    private Integer chainId;
    private String chainName;       // pulled from ChainEntity
    private String serviceDetails;
    private Integer qty;
    private Float costPerQty;
    private Float amountPayable;
    private Float balance;
    private LocalDateTime dateOfPayment;
    private LocalDate dateOfService;
    private String deliveryDetails;
    private String emailId;

    //Getters

    public Integer getEstimatedId() {
        return estimatedId;
    }

    public Integer getChainId() {
        return chainId;
    }

    public Float getAmountPayable() {
        return amountPayable;
    }

    public Float getCostPerQty() {
        return costPerQty;
    }

    public String getDeliveryDetails() {
        return deliveryDetails;
    }

    public Float getBalance() {
        return balance;
    }

    public LocalDate getDateOfService() {
        return dateOfService;
    }

    public LocalDateTime getDateOfPayment() {
        return dateOfPayment;
    }

    public String getEmailId() {
        return emailId;
    }

    public Integer getQty() {
        return qty;
    }

    public String getServiceDetails() {
        return serviceDetails;
    }

    public Integer getInvoiceNo() {
        return invoiceNo;
    }

    public Integer getId() {
        return id;
    }

    public String getChainName() {
        return chainName;
    }
    //Setters

    public void setEstimatedId(Integer estimatedId) {
        this.estimatedId = estimatedId;
    }

    public void setDeliveryDetails(String deliveryDetails) {
        this.deliveryDetails = deliveryDetails;
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

    public void setDateOfService(LocalDate dateOfService) {
        this.dateOfService = dateOfService;
    }

    public void setServiceDetails(String serviceDetails) {
        this.serviceDetails = serviceDetails;
    }

    public void setInvoiceNo(Integer invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public void setChainId(Integer chainId) {
        this.chainId = chainId;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setChainName(String chainName) {
        this.chainName = chainName;
    }
}
