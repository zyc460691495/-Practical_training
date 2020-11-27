package com.zyc.springbootsell.services.impl;

import com.zyc.springbootsell.dataobject.ProductCategory;
import com.zyc.springbootsell.repository.ProductCategoryRepo;
import com.zyc.springbootsell.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    ProductCategoryRepo repo;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repo.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repo.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryType(List<Integer> list) {
//        List result=new ArrayList();
//        List<ProductCategory> all = repo.findAll();
//        for (Integer integer:list){
//            for (ProductCategory p:all){
//                if (p.getCategoryType()==integer){
//                    result.add(p);
//                }
//            }
//        }
//        return result;

        return repo.findByCategoryTypeIn(list);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repo.save(productCategory);
    }
}
