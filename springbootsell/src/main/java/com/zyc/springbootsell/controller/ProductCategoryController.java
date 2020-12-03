package com.zyc.springbootsell.controller;


import com.zyc.springbootsell.dataobject.ProductCategory;
import com.zyc.springbootsell.repository.ProductCategoryRepo;
import com.zyc.springbootsell.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController {

    @Autowired
    CategoryService service;

    @GetMapping("/findOne/{categoryId}")
    public ProductCategory findOne(@PathVariable Integer categoryId) {
        return service.findOne(categoryId);
    }



//    @GetMapping("/page")
//    public Page<ProductCategory> pageQuery(@RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum,
//                                           @RequestParam(value = "pageSize", defaultValue = "2") Integer pageSize) {
//        PageRequest pageRequest = new PageRequest(pageNum, pageSize);
//        return service.;
//    }


//    @Autowired
//    ProductCategoryRepo repo;
//
//    @GetMapping("/findOne/{categoryId}")
//    public ProductCategory findOne(@PathVariable Integer categoryId){
//        return repo.findOne(categoryId);
//    }
//
//    @GetMapping("/page")
//    public Page<ProductCategory> pageQuery(@RequestParam(value = "pageNum",defaultValue = "0") Integer pageNum,
//                                           @RequestParam(value = "pageSize",defaultValue = "2") Integer pageSize){
//        PageRequest pageRequest = new PageRequest(pageNum, pageSize);
//        return repo.findAll(pageRequest);
//    }

}
