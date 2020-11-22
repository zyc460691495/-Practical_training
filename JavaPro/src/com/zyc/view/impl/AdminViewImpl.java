package com.zyc.view.impl;

import com.zyc.dao.AdminDao;
import com.zyc.dao.impl.AdminDaoImpl;
import com.zyc.domain.Admin;
import com.zyc.view.AdminView;

import java.util.Scanner;

public class AdminViewImpl implements AdminView {
    private Scanner input =  new Scanner(System.in);

    @Override
    public Admin login() {
        System.out.println("请输入用户名");
        String adminName = input.next();
        System.out.println("请输入密码");
        String password = input.next();
        AdminDao dao = new AdminDaoImpl();
        Admin admin = dao.getAdminByNameAndPassword(adminName, password);
        return admin;
    }
}
