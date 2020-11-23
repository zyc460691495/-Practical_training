package com.zyc;

import com.zyc.domain.Business;
import com.zyc.view.BusinessView;
import com.zyc.view.FoodView;
import com.zyc.view.impl.BusinessViewImpl;
import com.zyc.view.impl.FoodViewImpl;

import java.util.Scanner;

public class BusinessAdminEntry {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner input =  new Scanner(System.in);
        System.out.println("-----------------------------------");
        System.out.println("---------饿了么商家管理系统----------");
        System.out.println("-----------------------------------");
        BusinessView businessView=new BusinessViewImpl();
        Business business=new BusinessViewImpl().login();
        if(business!=null){
            System.out.println("商家 "+business.getBusinessName()+ "欢迎您回来！");
            int menu=0;
            while (menu != 5){
                System.out.println("1. 查看商家信息   2. 修改商家信息    3. 修改密码    4. 所属商品管理   5. 退出系统");
                System.out.println("请输入你要选择的序号");
                menu = input.nextInt();
                switch (menu){
                    case 1:
                        System.out.println(business.toString());
                        break;
                    case 2:
                        businessView.updateBusiness(business);
                        break;
                    case 3:
                        businessView.updateBusinessPassword(business.getBusinessId());
                        break;
                    case 4:
                        foodMangement(business.getBusinessId());
                        break;
                    case 5:
                        System.out.println("欢迎下次登录");
                        break;
                    default:
                        System.out.println("没有这个选项");
                        break;
                }
            }
        }else{
            System.out.println("登录失败, 用户名密码错误");
        }
    }
    public static void foodMangement(Integer businessId){
        Scanner input=new Scanner(System.in);
        FoodView foodView=new FoodViewImpl();
        int menu=0;
        while (menu!=5){
            System.out.println(">>> 二级菜单  1. 查看食品信息   2. 修改食品信息    3. 增加食品信息    4. 删除食品信息   5. 返回上一级菜单");
            System.out.println("请输入你要选择的序号");
            menu=input.nextInt();
            switch (menu){
                case 1:
                    foodView.showFoodList(businessId);
                    break;
                case 2:
                    foodView.updateFood(businessId);
                    break;
                case 3:
                    foodView.saveFood(businessId);
                    break;
                case 4:
                    foodView.removeFood(businessId);
                    break;
                case 5:
                    System.out.println("已返回上一级菜单");
                    break;
                default:
                    System.out.println("没有这个选项");
                    break;

            }
        }

    }
}
