package com.zyc.springbootsell.controller;


import com.zyc.springbootsell.dataobject.OrderDetail;
import com.zyc.springbootsell.repository.OrderDteailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {

    @Autowired
    OrderDteailRepo repo;

    //查找
    @GetMapping("/findAll")
    public List<OrderDetail> findAll(){
        return repo.findAll();
    }
    @GetMapping("/findOne/{orderId}")
    public OrderDetail findOne(@PathVariable("orderId") String orderId){
        return repo.findOne(orderId);
    }

    //增加
    @PostMapping("/new")
    public OrderDetail update(@RequestBody OrderDetail orderDetail){
        return repo.save(orderDetail);
    }

    //修改
    @PutMapping("/update/{orderId}")
    public OrderDetail update(@PathVariable("orderId") String orderId,
                              @RequestBody OrderDetail orderDetail){
        return repo.save(orderDetail);
    }

    //删除
    @DeleteMapping("/remove")
    public void remove(@RequestParam(value = "orderId") String orderId){
        repo.delete(orderId);
    }
}
