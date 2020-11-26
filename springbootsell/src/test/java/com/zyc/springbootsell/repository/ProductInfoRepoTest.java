package com.zyc.springbootsell.repository;


import com.zyc.springbootsell.dataobject.ProductInfo;
import com.zyc.springbootsell.enums.ProductStatusEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductInfoRepoTest {
    @Autowired
    private ProductInfoRepo productInfoRepo;

    @Test
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("3");
        productInfo.setProductName("hass");
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        productInfoRepo.save(productInfo);
    }

    @Test
    public void remove(){


    }

    @Test
    public void find(){

    }

    @Test
    public void update(){

    }
}
