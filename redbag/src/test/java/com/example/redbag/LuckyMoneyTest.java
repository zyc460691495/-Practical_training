package com.example.redbag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LuckyMoneyTest {
    @Autowired
    private LuckMoneyRepo repo;
    @Test
    public void listAll(){

        List<LuckyMoney> list=repo.findAll();
        for (LuckyMoney l:list){
            System.out.println(l);
        }

    }
}
