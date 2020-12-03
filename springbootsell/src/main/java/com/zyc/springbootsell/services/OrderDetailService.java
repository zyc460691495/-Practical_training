package com.zyc.springbootsell.services;

import com.zyc.springbootsell.dataobject.OrderDetail;
import com.zyc.springbootsell.dataobject.ProductCategory;

import java.util.List;

public interface OrderDetailService {

    public OrderDetail findOne(String orderId);

    public List<OrderDetail> findAll();

    public OrderDetail save(OrderDetail orderDetail);

    public List<OrderDetail> findByOrderId(String orderId);
}
