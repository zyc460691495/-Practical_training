package com.zyc.domain;

public class Food {

    private Integer foodId;
    private String foodName;
    private String foodExplain;
    private Double foodPrice;
    private Integer businessId;

    public Food() {
    }

    public Food(Integer foodId, String foodName, String foodExplain, Double foodPrice, Integer businessId) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodExplain = foodExplain;
        this.foodPrice = foodPrice;
        this.businessId = businessId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodExplain() {
        return foodExplain;
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodExplain(String foodExplain) {
        this.foodExplain = foodExplain;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    @Override
    public String toString() {
        return "Food [foodId=" + foodId + ", foodName=" + foodName + ", foodExplain=" + foodExplain + ", foodPrice="
                + foodPrice + ", businessId=" + businessId + "]";
    }
}
