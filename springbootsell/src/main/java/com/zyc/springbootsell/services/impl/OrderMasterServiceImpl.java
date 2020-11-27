package com.zyc.springbootsell.services.impl;

import com.zyc.springbootsell.dataobject.OrderMaster;
import com.zyc.springbootsell.repository.OrderMasterRepo;
import com.zyc.springbootsell.services.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderMasterServiceImpl implements OrderMasterService {

    @Autowired
    private OrderMasterRepo repo;

    @Override
    public OrderMaster findOne(String orderId) {
        return repo.findOne(orderId);
    }

    @Override
    public List<OrderMaster> findAll() {
        return repo.findAll();
    }

    @Override
    public OrderMaster save(OrderMaster orderMaster) {
        return repo.save(orderMaster);
    }
}
