package com.zyc.springbootsell.service.Impl;

import com.zyc.springbootsell.dataobject.Admin;
import com.zyc.springbootsell.services.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceImplTest {
    @Autowired
    private AdminService adminService;

    @Test
    public void login(){
        Admin admin1 = adminService.checkUser("admin1", "123");
        System.out.println(admin1);
    }

}
