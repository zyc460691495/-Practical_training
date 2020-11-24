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
    @Autowired//对成员变量、方法和构造函数进行标注，来完成自动装配的工作
    private LuckMoneyRepo repo;
    @Test//不用new就可以执行方法
    // 指定将会抛出的异常类型，如果没有抛出异常或者抛出的异常不属于指定的类型，就会算是测试失败了 测试一断代码运行时间
    public void listAll(){

        List<LuckyMoney> list=repo.findAll();
        for (LuckyMoney l:list){
            System.out.println(l);
        }

    }
}
