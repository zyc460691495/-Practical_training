package com.zyc.springbootsell.service.Impl;
import java.math.BigDecimal;
import java.util.Date;

import com.zyc.springbootsell.dataobject.OrderMaster;
import com.zyc.springbootsell.services.OrderMasterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterServiceImplTest {

    @Autowired
    OrderMasterService service;

    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("12121");
        orderMaster.setUserName("zzz");
        orderMaster.setBuyerPhone("13773272344");
        orderMaster.setBuyerAddress("7#121");
        orderMaster.setBuyerOpenId("1001");
        orderMaster.setOrderAmount(new BigDecimal("0"));
        orderMaster.setOrderStatus(0);
        orderMaster.setPayStatus(0);
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());

        System.out.println(service.save(orderMaster));
    }
}
