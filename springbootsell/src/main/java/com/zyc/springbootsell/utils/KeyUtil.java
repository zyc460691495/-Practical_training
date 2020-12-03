package com.zyc.springbootsell.utils;

import com.zyc.springbootsell.dataobject.ProductCategory;
import com.zyc.springbootsell.repository.ProductCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;

public class KeyUtil {


    @Autowired
    private static ProductCategoryRepo repo;

    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number =  random.nextInt(900000)+ 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }

    public static synchronized Integer genUniqueCategoryType(){
        Random random = new Random();
        Integer number =  random.nextInt(900000);
        return number;
    }
}
