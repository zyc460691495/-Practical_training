package com.zyc.springbootsell.controller;


import com.zyc.springbootsell.dataobject.ProductInfo;
import com.zyc.springbootsell.repository.ProductInfoRepo;
import com.zyc.springbootsell.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productInfo")
public class ProductInfoController {

    @Autowired
    private ProductService service;


    //查询
    @GetMapping("/findAllUp")
    public List<ProductInfo> findAllUp(){
        return service.findAllUp();
    }

    @GetMapping("/findByPage")
    public List<ProductInfo> findByPage(@RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum,
                                           @RequestParam(value = "pageSize", defaultValue = "1") Integer pageSize){
        Pageable pageable =new PageRequest(pageNum,pageSize);
        Page<ProductInfo> allPage = service.findAllPage(pageable);
        return allPage.getContent();
    }

    //增加
    @PostMapping("/new")
    public ProductInfo save(@RequestBody ProductInfo productInfo){
        return service.save(productInfo);
    }

    //修改
    @PutMapping("/update/{productId}")
    public ProductInfo update(@PathVariable("productId") String productId,
                              @RequestBody ProductInfo productInfo){
        productInfo.setProductId(productId);
        return service.save(productInfo);
    }






//    @Autowired
//    private ProductInfoRepo repo;
//
//
//    //查询
//    @GetMapping("/findAll")
//    public List<ProductInfo> findAll(){
//        return repo.findAll();
//    }
//
//    //增加
//    @PostMapping("/new")
//    public ProductInfo save(@RequestBody ProductInfo productInfo){
//        return repo.save(productInfo);
//    }
//
//    //删除
//    @DeleteMapping("/remove")
//    public void remove(@RequestParam(value = "productId") String productId){
//        repo.delete(productId);
//    }
//
//    //修改
//    @PutMapping("/update/{productId}")
//    public ProductInfo update(@PathVariable("productId") String productId,
//                              @RequestBody ProductInfo productInfo){
//        productInfo.setProductId(productId);
//        return repo.save(productInfo);
//    }
}
