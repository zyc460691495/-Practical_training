package com.zyc.springbootsell.service.Impl;

import com.zyc.springbootsell.dataobject.ProductInfo;
import com.zyc.springbootsell.services.ProductService;
import com.zyc.springbootsell.services.impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PutMapping;

import java.awt.print.Book;
import java.awt.print.Pageable;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    public void findOne(){
        ProductInfo productInfo = productService.findOne("1");
        System.out.println(productInfo);
        Assert.assertEquals("1", productInfo.getProductId());
    }

    @Test
    public void findAllUp(){
        List<ProductInfo> allUp = productService.findAllUp();
        for(ProductInfo p:allUp){
            System.out.println(p);
        }
    }

    @Test
    public void findAllPage(){
        Pageable pageable=new Book();
        productService.findAllPage();
    }

}
