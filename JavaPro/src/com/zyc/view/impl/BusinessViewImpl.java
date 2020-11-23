package com.zyc.view.impl;

import com.zyc.dao.BusinessDao;
import com.zyc.dao.impl.BusinessDaoImpl;
import com.zyc.domain.Business;
import com.zyc.view.BusinessView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BusinessViewImpl implements BusinessView {
    private Scanner input = new Scanner(System.in);

    @Override
    public void listAllBusiness() {
        BusinessDao dao = new BusinessDaoImpl();
        List<Business> list = dao.listBusiness(null, null);

        for (Business b : list) {
            System.out.println(b.getBusinessId() + "\t" + b.getBusinessName() +
                    "\t" + b.getBusinessAddress() + "\t" + b.getBusinessExplain() +
                    "\t" + b.getDeliveryPrice() + "\t" + b.getStarPrice());
        }
    }

    @Override
    public void selectBusiness() {
        BusinessDao dao = new BusinessDaoImpl();
        String businessName = "";
        String businessAdress = "";
        System.out.println("是否输入商家名称关键字（yes/no）");
        String flag = input.next();
        if (flag.equals("yes")) {
            System.out.println("请输入商家名称关键词");
            businessName = input.next();
        }
        System.out.println("是否输入商家地址关键字（yes/no）");
        flag = input.next();
        if (flag.equals("yes")) {
            System.out.println("请输入商家地址关键字");
            businessAdress = input.next();
        }
        List<Business> list = dao.listBusiness(businessName, businessAdress);
//        System.out.format("%s %s %s %s %s %s","商家编号","商家名称","商家地址","","配送费","商品价格");
//        System.out.format("%d %s %s %s %a %a","");
        for (Business b : list) {
            System.out.println(b.getBusinessId() + "\t" + b.getBusinessName() +
                    "\t" + b.getBusinessAddress() + "\t" + b.getBusinessExplain() +
                    "\t" + b.getDeliveryPrice() + "\t" + b.getStarPrice());
        }
    }

    @Override
    public void addBusiness() {
        BusinessDao dao=new BusinessDaoImpl();
        System.out.println("请输入新商家的名称");
        String businessName = input.next();
        System.out.println("请输入新商家的密码");
        String businessPassword=input.next();
        int businessId = dao.addBusiness(businessName,businessPassword);
        // 根据id进行查询， 然后进行回显
        if (businessId >0){
            System.out.println("保存成功");
            Business business = dao.getBusinessById(businessId);
            System.out.println(business);
        }else {
            System.out.println("新建商家失败");
        }
    }

    @Override
    public void removeBusiness() {
        BusinessDao dao=new BusinessDaoImpl();
        System.out.println("请输入要移除商家的编号");
        Integer businessId=input.nextInt();
        dao.removeBusiness(businessId);
        System.out.println("是否移除（yes/no）");
        String flag=input.next();
        if(flag.equals("yes")){
            System.out.println("商家已移除");
        }
    }

    @Override
    public Business login() {
        System.out.println("请输入商家编号");
        Integer businessId=input.nextInt();
        System.out.println("请输入密码");
        String password=input.next();
        BusinessDao businessDao=new BusinessDaoImpl();
        return businessDao.getBusinessByIdAndPassword(businessId,password);
    }

    @Override
    public void updateBusiness(Business business) {
        System.out.println(business.toString());
        String flag="";
        String businessName=business.getBusinessName();
        String businessAddress=business.getBusinessAddress();
        String businessExplain=business.getBusinessExplain();
        Double startPrice=business.getDeliveryPrice();
        Double deliveryPrice=business.getDeliveryPrice();
        System.out.println("是否更改商家名称（yes/no）");
        flag=input.next();
        if(flag.equals("yes")){
            System.out.println("请输入新的商家名称");
            businessName=input.next();
            business.setBusinessName(businessName);
        }
        System.out.println("是否更改商家地址（yes/no）");
        flag=input.next();
        if(flag.equals("yes")){
            System.out.println("请输入新的商家地址");
            businessAddress=input.next();
            business.setBusinessAddress(businessAddress);
        }
        System.out.println("是否更改商家介绍（yes/no）");
        flag=input.next();
        if(flag.equals("yes")){
            System.out.println("请输入新的商家介绍");
            businessExplain=input.next();
            business.setBusinessAddress(businessExplain);
        }else {

        }
        System.out.println("是否更改起送价格（yes/no）");
        flag=input.next();
        if(flag.equals("yes")){
            System.out.println("请输入新的起送价格");
            startPrice=input.nextDouble();
            business.setStarPrice(startPrice);
        }
        System.out.println("是否更改配送价格（yes/no）");
        flag=input.next();
        if(flag.equals("yes")){
            System.out.println("请输入新的配送价格");
            deliveryPrice=input.nextDouble();
            business.setDeliveryPrice(deliveryPrice);
        }
        BusinessDao businessDao=new BusinessDaoImpl();
        int res=businessDao.updateBusiness(business);
        if (res==1){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }
    }

    @Override
    public void updateBusinessPassword(Integer businessId) {
        BusinessDao businessDao=new BusinessDaoImpl();
        Business business=businessDao.getBusinessById(businessId);
        System.out.println("请输入旧密码");
        String password=input.next();
        if(!password.equals(business.getPassword())){
            System.out.println("旧密码错误！！！");
        }else {
            System.out.println("请输入新密码");
            String newpassword=input.next();
            System.out.println("请再次输入新密码");
            if(input.next().equals(newpassword)){
                int rs=businessDao.updateBusinessPassword(businessId,newpassword);
                if (rs>0){
                    System.out.println("修改密码成功");
                }else {
                    System.out.println("修改密码失败");
                }
            }else {
                System.out.println("两次密码输入不一致");
            }
        }
    }
}
