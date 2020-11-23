package com.zyc.view.impl;

import com.zyc.dao.BusinessDao;
import com.zyc.dao.FoodDao;
import com.zyc.dao.impl.BusinessDaoImpl;
import com.zyc.dao.impl.FoodDaoImpl;
import com.zyc.domain.Business;
import com.zyc.domain.Food;
import com.zyc.view.FoodView;

import java.util.List;
import java.util.Scanner;

public class FoodViewImpl implements FoodView {
    private Scanner input = new Scanner(System.in);

    @Override
    public void showFoodList(Integer businessId) {
        FoodDao dao = new FoodDaoImpl();
        List<Food> list = dao.listFoodByBusinessId(businessId);

        System.out.format("%-10s %20s %20s %20s %20s\n","食品编号","食品名称","食品介绍","食品价格","商家编号");
        for (Food f : list) {
            System.out.format("%-10d %25s %15s %23f %21d", f.getFoodId(), f.getFoodName(),
                    f.getFoodExplain(), f.getFoodPrice(), f.getBusinessId());
            System.out.println();
        }
    }

    @Override
    public void saveFood(Integer businessId) {
        FoodDao dao = new FoodDaoImpl();
        Food food = new Food();
        System.out.println("请输入新食品的名称");
        String foodName = input.next();
        System.out.println("请输入新食品的价格");
        Double foodPrice = input.nextDouble();

        food.setFoodName(foodName);
        food.setFoodPrice(foodPrice);
        food.setBusinessId(businessId);

        int foodId = dao.saveFood(food);
        // 根据id进行查询， 然后进行回显
        if (foodId > 0) {
            System.out.println("保存成功");
            Food food1 = dao.getFoodById(foodId);
            System.out.println(food1);
        } else {
            System.out.println("新建食品失败");
        }
    }

    @Override
    public void updateFood(Integer businessId) {

        showFoodList(businessId);
        System.out.println("请输入要修改食品的编号");
        Integer foodId = input.nextInt();
        FoodDao foodDao = new FoodDaoImpl();
        if (businessId.intValue() != foodDao.getFoodById(foodId).getBusinessId().intValue()) {
            System.out.println("店内没有该编号的食品");
            return;
        }
        Food food = foodDao.getFoodById(foodId);

        String flag = "";
        String foodName = food.getFoodName();
        String foodExplain = food.getFoodExplain();
        Double foodPrice = food.getFoodPrice();
        System.out.println("是否更改食品名称（yes/no）");
        flag = input.next();
        if (flag.equals("yes")) {
            System.out.println("请输入新的食品名称");
            foodName = input.next();
            food.setFoodName(foodName);
        }
        System.out.println("是否更改食品介绍（yes/no）");
        flag = input.next();
        if (flag.equals("yes")) {
            System.out.println("请输入新的食品介绍");
            foodExplain = input.next();
            food.setFoodExplain(foodExplain);
        }
        System.out.println("是否更改食品价格（yes/no）");
        flag = input.next();
        if (flag.equals("yes")) {
            System.out.println("请输入新的食品价格");
            foodPrice = input.nextDouble();
            food.setFoodPrice(foodPrice);
        }
        System.out.println(food.toString());
        int res = foodDao.updateFood(food);
        if (res == 1) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    @Override
    public void removeFood(Integer businessId) {
        showFoodList(businessId);
        FoodDao dao = new FoodDaoImpl();
        System.out.println("请输入要移除食品的编号");
        Integer foodId = input.nextInt();

        if (businessId.intValue() != dao.getFoodById(foodId).getBusinessId().intValue()) {
            System.out.println("店内没有该编号的食品");
            return;
        }
        dao.removeFood(foodId);
        System.out.println("是否移除（yes/no）");
        String flag = input.next();
        if (flag.equals("yes")) {
            System.out.println("食品已移除");
        }
    }
}
