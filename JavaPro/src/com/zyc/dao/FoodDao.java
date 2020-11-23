package com.zyc.dao;

import com.zyc.domain.Food;

import java.util.List;

public interface FoodDao {
    public List<Food> listFoodByBusinessId(Integer businessId);
    public int saveFood(Food food);
    public int updateFood(Food food);
    public int removeFood(Integer foodId);
    public  Food getFoodById(Integer foodId);
}
