package com.zyc.springbootsell.repository;


import com.zyc.springbootsell.dataobject.Seller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SellerRepoTest {

    @Autowired
    SellerRepo repo;

    @Test
    public void find(){
        List<Seller> all = repo.findAll();
        for (Seller s:all){
            System.out.println(s);
        }
    }
}
