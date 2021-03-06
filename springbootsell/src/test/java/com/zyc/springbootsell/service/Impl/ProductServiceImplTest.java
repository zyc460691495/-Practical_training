package com.zyc.springbootsell.service.Impl;

import com.zyc.springbootsell.dataobject.ProductInfo;
import com.zyc.springbootsell.enums.ProductStatusEnum;
import com.zyc.springbootsell.services.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    public void findOne(){
        ProductInfo productInfo = productService.findOne("121");
        System.out.println(productInfo.toString());
        Assert.assertEquals("122", productInfo.getProductId());
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
        Pageable pageable =new PageRequest(0,2, Sort.Direction.ASC,"productId");
        Page<ProductInfo> allPage = productService.findAllPage(pageable);
        List<ProductInfo> content = allPage.getContent();
        for (ProductInfo p :content){
            System.out.println(p.toString());
        }
    }
    @Test
    public void save() {
        ProductInfo productInfo =new ProductInfo();
        productInfo.setProductId("shaod");
        System.out.println(productService.save(productInfo));
    }

    @Test
    public void onSale(){
        ProductInfo productInfo = productService.onSale("121");
        Assert.assertEquals(ProductStatusEnum.UP.getCode(),productInfo.getProductStatus());
    }

    @Test
    public void offSale(){
        productService.offSale("444");
    }
    @Test
    public void increaseStock() {
        productService.increaseStock("1");
    }

    @Test
    public void decreseStock() {
        productService.decreseStock("1");
    }

}
