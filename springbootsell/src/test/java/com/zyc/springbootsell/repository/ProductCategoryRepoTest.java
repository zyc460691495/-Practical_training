package com.zyc.springbootsell.repository;

import com.zyc.springbootsell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductCategoryRepoTest {

    @Autowired
    private ProductCategoryRepo productCategoryRepo;

    @Test
    public void save(){
        ProductCategory productCategory=new ProductCategory();
//        productCategory.setCategoryId(123);
//        设置主键自增后是自动给定id
        productCategory.setCategoryName("15");
//        System.out.println(productCategory);
        productCategoryRepo.save(productCategory);

    }

    @Test
    public void remove(){
        productCategoryRepo.delete(3);
    }

    @Test
    public void find(){
        productCategoryRepo.findOne(3);
    }

    @Test
    public void update(){
        ProductCategory one = productCategoryRepo.findOne(3);
        one.setCategoryName("woshi");
        productCategoryRepo.save(one);
    }
}
