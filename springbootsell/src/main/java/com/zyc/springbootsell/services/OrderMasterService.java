package com.zyc.springbootsell.services;

import com.zyc.springbootsell.dataobject.OrderMaster;

import java.util.List;

public interface OrderMasterService {
    public OrderMaster findOne(String orderId);

    public List<OrderMaster> findAll();

    public OrderMaster save(OrderMaster orderMaster);



}
