package com.zyc.springbootsell.controller;


import com.zyc.springbootsell.dataobject.OrderDetail;
import com.zyc.springbootsell.dataobject.OrderMaster;
import com.zyc.springbootsell.repository.OrderMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderMaster")
public class OrderMasterController {

    @Autowired
    OrderMasterRepo repo;

    //查找
    @GetMapping("/findOne/{orderId}")
    public OrderMaster findOne(@PathVariable("orderId") String orderId){
        return repo.findOne(orderId);
    }
    @GetMapping("/findAll")
    public List<OrderMaster> findAll(){
        return repo.findAll();
    }

    //增加
    @PostMapping("/new")
    public OrderMaster save(@RequestBody OrderMaster orderMaster){
        return repo.save(orderMaster);
    }

    //更新
    @PutMapping("/update/{orderId}")
    public OrderMaster update(@PathVariable("orderId") String orderId,
                              @RequestBody OrderMaster orderMaster){
        return repo.save(orderMaster);
    }

}
