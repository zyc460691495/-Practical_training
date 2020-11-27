package com.zyc.springbootsell.service.Impl;

import com.zyc.springbootsell.dataobject.ProductCategory;
import com.zyc.springbootsell.services.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findOne() {
        System.out.println(categoryService.findOne(1));
    }

    @Test
    public void findAll() {
        List<ProductCategory> all = categoryService.findAll();
        for (ProductCategory p:all){
            System.out.println(p);
        }
    }

    @Test
    public void findByCategoryType() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        List<ProductCategory> byCategoryType = categoryService.findByCategoryType(integers);
        for (ProductCategory p:byCategoryType){
            System.out.println(p);
        }
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(121);
        categoryService.save(productCategory);
//        Assert.assertNotNull();
    }
}
