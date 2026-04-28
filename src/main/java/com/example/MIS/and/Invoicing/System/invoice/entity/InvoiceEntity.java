package com.example.MIS.and.Invoicing.System.invoice.entity;

import com.example.MIS.and.Invoicing.System.chainmanagement.entity.ChainEntity;
import com.example.MIS.and.Invoicing.System.estimation.entity.EstimationEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "invoices")
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "invoice_no", unique = true, nullable = false)
    private Integer invoiceNo;

    @ManyToOne
    @JoinColumn(name = "estimated_id", nullable = false)
    private EstimationEntity estimation;

    @ManyToOne
    @JoinColumn(name = "chain_id", nullable = false)
    private ChainEntity chain;

    @Column(name = "service_details")
    private String serviceDetails;

    private Integer qty;

    @Column(name = "cost_per_qty")
    private Float costPerQty;

    @Column(name = "amount_payable")
    private Float amountPayable;

    private Float balance;

    @Column(name = "date_of_payment")
    private LocalDateTime dateOfPayment;

    @Column(name = "date_of_service")
    private LocalDate dateOfService;

    @Column(name = "delivery_details")
    private String deliveryDetails;

    @Column(name = "email_id")
    private String emailId;

    // getters

    public String getDeliveryDetails() {
        return deliveryDetails;
    }

    public Integer getQty() {
        return qty;
    }

    public ChainEntity getChain() {
        return chain;
    }

    public Integer getId() {
        return id;
    }

    public EstimationEntity getEstimation() {
        return estimation;
    }

    public Float getAmountPayable() {
        return amountPayable;
    }

    public Float getBalance() {
        return balance;
    }

    public Float getCostPerQty() {
        return costPerQty;
    }

    public Integer getInvoiceNo() {
        return invoiceNo;
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

    public String getServiceDetails() {
        return serviceDetails;
    }
    //Setters

    public void setDeliveryDetails(String deliveryDetails) {
        this.deliveryDetails = deliveryDetails;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public void setChain(ChainEntity chain) {
        this.chain = chain;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAmountPayable(Float amountPayable) {
        this.amountPayable = amountPayable;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public void setCostPerQty(Float costPerQty) {
        this.costPerQty = costPerQty;
    }

    public void setDateOfPayment(LocalDateTime dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public void setDateOfService(LocalDate dateOfService) {
        this.dateOfService = dateOfService;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setInvoiceNo(Integer invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public void setEstimation(EstimationEntity estimation) {
        this.estimation = estimation;
    }

    public void setServiceDetails(String serviceDetails) {
        this.serviceDetails = serviceDetails;
    }
}
