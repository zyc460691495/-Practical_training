package com.zyc.springbootsell.repository;

import com.zyc.springbootsell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailRepoTest {

    @Autowired
    private OrderDteailRepo orderDteailRepo;

    @Test
    public void save(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("4");
        orderDetail.setOrderId("2");
        orderDetail.setProductIcon("2");
        orderDetail.setProductId("2");
        orderDetail.setProductPrice(new BigDecimal(121));
        orderDetail.setProductQuantity(12);
        orderDetail.setProductName("食物1");
        OrderDetail save = orderDteailRepo.save(orderDetail);
//        save=null;
        Assert.assertNotNull(save);
    }

    @Test
    public void remove(){
        orderDteailRepo.delete("4");
    }

    @Test
    public void findOne(){
        System.out.println(orderDteailRepo.findOne("4"));
    }

    @Test
    public void update(){
        OrderDetail one = orderDteailRepo.findOne("4");
        one.setProductName("newName");
        OrderDetail save = orderDteailRepo.save(one);
        Assert.assertNotNull(save);
    }

}
