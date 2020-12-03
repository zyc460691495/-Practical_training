package com.zyc.springbootsell.services;

import com.zyc.springbootsell.dataobject.OrderMaster;
import com.zyc.springbootsell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderMasterService {
    public OrderMaster findOne(String orderId);

    public List<OrderMaster> findAll();

    public OrderMaster save(OrderMaster orderMaster);

    Page<OrderMaster> findAllPage(Pageable pageable);

    public void remove(String orderId);
}
