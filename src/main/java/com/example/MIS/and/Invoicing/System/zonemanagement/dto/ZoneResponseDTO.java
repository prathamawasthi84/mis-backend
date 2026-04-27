package com.example.MIS.and.Invoicing.System.zonemanagement.dto;

public class ZoneResponseDTO {
    private Integer zoneId;
    private String zoneName;
    private String brandName;
    private String companyName;   // chain name
    private String groupName;

    //Getters

    public String getZoneName() {
        return zoneName;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getCompanyName() {
        return companyName;
    }
    //Setters

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}