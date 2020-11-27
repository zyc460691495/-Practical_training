package com.zyc.springbootsell.controller;


import com.zyc.springbootsell.dataobject.ProductInfo;
import com.zyc.springbootsell.repository.ProductInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productInfo")
public class ProductInfoController {


    @Autowired
    private ProductInfoRepo repo;


    //查询
    @GetMapping("/findAll")
    public List<ProductInfo> findAll(){
        return repo.findAll();
    }

    //增加
    @PostMapping("/new")
    public ProductInfo save(@RequestBody ProductInfo productInfo){
        return repo.save(productInfo);
    }

    //删除
    @DeleteMapping("/remove")
    public void remove(@RequestParam(value = "productId") String productId){
        repo.delete(productId);
    }

    //修改
    @PutMapping("/updatde/{productId}")
    public ProductInfo update(@PathVariable("productId") String productId,
                              @RequestBody ProductInfo productInfo){
        productInfo.setProductId(productId);
        return repo.save(productInfo);
    }
}
