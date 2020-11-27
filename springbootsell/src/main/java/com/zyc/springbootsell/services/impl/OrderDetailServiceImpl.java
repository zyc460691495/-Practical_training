package com.zyc.springbootsell.services.impl;
import java.math.BigDecimal;
import java.util.Date;

import com.zyc.springbootsell.dataobject.OrderDetail;
import com.zyc.springbootsell.repository.OrderDteailRepo;
import com.zyc.springbootsell.services.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDteailRepo repo;


    @Override
    public OrderDetail findOne(String orderId) {

        return repo.findOne(orderId);
    }

    @Override
    public List<OrderDetail> findAll() {

        return repo.findAll();
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) {

        return repo.save(orderDetail);
    }
}
