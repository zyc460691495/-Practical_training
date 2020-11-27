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
    @GetMapping("/findOne/{detailId}")
    public OrderDetail findOne(@PathVariable("detailId") String detailId){
        return repo.findOne(detailId);
    }

    //增加
    @PostMapping("/new")
    public OrderDetail save(@RequestBody OrderDetail orderDetail){
        return repo.save(orderDetail);
    }

    //修改
    @PutMapping("/update/{detailId}")
    public OrderDetail update(@PathVariable("detailId") String detailId,
                              @RequestBody OrderDetail orderDetail){
        return repo.save(orderDetail);
    }

    //删除
    @DeleteMapping("/remove")
    public void remove(@RequestParam(value = "detailId") String detailId){
        repo.delete(detailId);
    }
}
