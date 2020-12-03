package com.zyc.springbootsell.services;

import com.zyc.springbootsell.dataobject.ProductCategory;
import com.zyc.springbootsell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {


    public ProductCategory findOne(Integer categoryId);

    public List<ProductCategory> findAll();

    Page<ProductCategory> findAllPage(Pageable pageable);

    public List<ProductCategory> findByCategoryType(List<Integer> list);

    public ProductCategory save(ProductCategory productCategory);

    public void remove(Integer categoryId);





}

