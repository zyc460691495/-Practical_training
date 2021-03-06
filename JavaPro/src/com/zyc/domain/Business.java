package com.zyc.domain;

public class Business {
    private Integer businessId;
    private String password;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private Double starPrice;
    private Double deliveryPrice;


    public Business() {
    }


    public Business(Integer businessId, String password, String businessName, String businessAddress,
                    String businessExplain, Double starPrice, Double deliveryPrice) {
        this.businessId = businessId;
        this.password = password;
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.businessExplain = businessExplain;
        this.starPrice = starPrice;
        this.deliveryPrice = deliveryPrice;
    }


    public Integer getBusinessId() {
        return businessId;
    }


    public String getPassword() {
        return password;
    }


    public String getBusinessName() {
        return businessName;
    }


    public String getBusinessAddress() {
        return businessAddress;
    }


    public String getBusinessExplain() {
        return businessExplain;
    }


    public Double getStarPrice() {
        return starPrice;
    }


    public Double getDeliveryPrice() {
        return deliveryPrice;
    }


    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }


    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }


    public void setBusinessExplain(String businessExplain) {
        this.businessExplain = businessExplain;
    }


    public void setStarPrice(Double starPrice) {
        this.starPrice = starPrice;
    }


    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }


    @Override
    public String toString() {
        return "Business [businessId=" + businessId + ", password=" + password + ", businessName=" + businessName
                + ", businessAddress=" + businessAddress + ", businessExplain=" + businessExplain + ", starPrice="
                + starPrice + ", deliveryPrice=" + deliveryPrice + "]";
    }

}
