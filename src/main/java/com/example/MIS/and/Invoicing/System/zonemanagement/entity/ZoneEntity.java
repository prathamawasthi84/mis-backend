package com.example.MIS.and.Invoicing.System.zonemanagement.entity;

import com.example.MIS.and.Invoicing.System.brandmanagement.entity.BrandEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "zones")
public class ZoneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer zoneId;

    @Column(name = "zone_name", nullable = false, length = 50)
    private String zoneName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    private BrandEntity brand;

    @Column(name = "is_active")
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

    public Integer getZoneId() {
        return zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public Boolean getActive() {
        return isActive;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    //Setters

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setIsActive(boolean b) {
    }
}
