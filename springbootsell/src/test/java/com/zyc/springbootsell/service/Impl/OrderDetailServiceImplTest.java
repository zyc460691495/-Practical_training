package com.zyc.springbootsell.service.Impl;


import com.zyc.springbootsell.dataobject.OrderDetail;
import com.zyc.springbootsell.services.OrderDetailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailServiceImplTest {

    @Autowired
    private OrderDetailService service;

    @Test
    public void findOne(){
        System.out.println(service.findOne("12"));
    }

    @Test
    public void findAll(){

        List<OrderDetail> all = service.findAll();
        for (OrderDetail o:all){
            System.out.println(o);
        }
    }

    @Test
    public void save(){

        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("121");
        orderDetail.setOrderId("121");
        orderDetail.setProductId("121");
        orderDetail.setProductName("121");
        orderDetail.setProductPrice(new BigDecimal("0"));
        orderDetail.setProductQuantity(0);
        orderDetail.setProductIcon("121");
        orderDetail.setCreateTime(new Date());
        orderDetail.setUpdateTime(new Date());
        System.out.println(service.save(orderDetail));
    }
}
