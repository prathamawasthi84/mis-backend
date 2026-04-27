package com.example.MIS.and.Invoicing.System.brandmanagement.dto;

public class BrandDTO {
    private String brandName;
    private Integer chainId;

    //Getters

    public Integer getChainId() {
        return chainId;
    }

    public String getBrandName() {
        return brandName;
    }
    //Setters

    public void setChainId(Integer chainId) {
        this.chainId = chainId;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}

