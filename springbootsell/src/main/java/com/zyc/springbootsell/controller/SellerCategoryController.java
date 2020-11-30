package com.zyc.springbootsell.controller;

import com.zyc.springbootsell.dataobject.ProductCategory;
import com.zyc.springbootsell.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller")
public class SellerCategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/list")
    public ModelAndView list(Map<String,Object> map){
        List<ProductCategory> all = service.findAll();
        map.put("categoryList",all);
        return new ModelAndView("category/listxiesi",map);
    }





}
