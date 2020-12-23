package com.zyc.springbootsell.repository;

import com.zyc.springbootsell.dataobject.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminRepoTest {

    @Autowired
    private AdminRepo adminRepo;

    @Test
    public void check(){
        Admin admin1 = adminRepo.findAdminByUsernameAndPassword("admin1", "123");
        System.out.println(admin1);
    }
}
