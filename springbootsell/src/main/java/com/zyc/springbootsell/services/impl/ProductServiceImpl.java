package com.zyc.springbootsell.services.impl;

import com.zyc.springbootsell.dataobject.ProductInfo;
import com.zyc.springbootsell.enums.ProductStatusEnum;
import com.zyc.springbootsell.repository.ProductInfoRepo;
import com.zyc.springbootsell.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepo repo;

    @Override
    public ProductInfo findOne(String productId) {
        return  repo.findOne(productId);
    }

    @Override
    public List<ProductInfo> findAllUp() {
        List<ProductInfo> all = repo.findAll();
        List list=new ArrayList();
        for (ProductInfo p:all){
            if(p.getProductStatus()== ProductStatusEnum.UP.getCode()){
                list.add(p);
            }
        }
        return list;
    }

    @Override
    public Page<ProductInfo> findAllPage(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repo.save(productInfo);
    }

    @Override
    public void increaseStock(String productId) {
        ProductInfo one = repo.findOne(productId);
        one.setProductStock(one.getProductStock()+10);
        repo.save(one);
    }

    @Override
    public void decreseStock(String productId) {
        ProductInfo one = repo.findOne(productId);
        if(one.getProductStock()>10){
            one.setProductStock(one.getProductStock()-10);
        }else {
            System.out.println("失败");
        }
        repo.save(one);
    }
}
