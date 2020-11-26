package com.zyc.springbootsell.repository;

import com.zyc.springbootsell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMasterRepoTest {
    @Autowired
    private OrderMasterRepo orderMasterRepo;

    @Test
    public void save(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("7");
        OrderMaster save = orderMasterRepo.save(orderMaster);
        Assert.assertNotNull(save);
    }
    
    @Test
    public void remove(){
        orderMasterRepo.delete("7");
    }
    
    @Test
    public void find(){
        System.out.println(orderMasterRepo.findOne("7"));
    }

    @Test
    public void update(){
        OrderMaster one = orderMasterRepo.findOne("7");
        one.setBuyerAddress("江科大");
        orderMasterRepo.save(one);
    }

}
