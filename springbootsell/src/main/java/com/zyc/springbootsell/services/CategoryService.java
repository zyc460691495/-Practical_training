package com.zyc.springbootsell.services;

import com.zyc.springbootsell.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {


    public ProductCategory findOne(Integer categoryId);

    public List<ProductCategory> findAll();

    public List<ProductCategory> findByCategoryType(List<Integer> list);

    public ProductCategory save(ProductCategory productCategory);





}

