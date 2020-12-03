package com.zyc.springbootsell.controller;

import com.lly835.bestpay.rest.type.Get;
import com.zyc.springbootsell.dataobject.ProductCategory;
import com.zyc.springbootsell.dataobject.ProductInfo;
import com.zyc.springbootsell.exception.SellException;
import com.zyc.springbootsell.form.CategoryForm;
import com.zyc.springbootsell.form.ProductForm;
import com.zyc.springbootsell.services.CategoryService;
import com.zyc.springbootsell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "2") Integer pageSize,
                             Map<String, Object> map) {
        Pageable pageable = new PageRequest(pageNum - 1, pageSize);
        Page<ProductCategory> allPage = service.findAllPage(pageable);
        map.put("productCategoryPage", allPage);
        map.put("currentPage", pageNum);
        map.put("pageSize", pageSize);
        return new ModelAndView("category/list", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                              Map<String, Object> map) {

        if (!StringUtils.isEmpty(categoryId)) {
            ProductCategory category = service.findOne(categoryId);
            map.put("category", category);
        }
//        List<ProductCategory> categoryList = service.findAll();
//        map.put("categoryList",categoryList);

        return new ModelAndView("category/index");
    }


    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult result,
                             Map<String, Object> map) {
        System.out.println(form);
        ProductCategory category = new ProductCategory();
        try {
            if (!StringUtils.isEmpty(form.getCategoryId())) {
                //类目已存在修改
                category = service.findOne(form.getCategoryId());
                System.out.println("修改");
            } else {
                //不存在 赋id、类型
                form.setCategoryType(KeyUtil.genUniqueCategoryType());
                System.out.println("新建");
            }
            BeanUtils.copyProperties(form, category);
//            System.out.println(productInfo.toString());
            service.save(category);
        } catch (SellException exception) {
            //修改失败
            map.put("msg", exception.getMessage());
            map.put("url", "/seller/category/index");
            return new ModelAndView("common/error", map);
        }
        //修改成功返回页面
        map.put("url", "/seller/category/list");
        return new ModelAndView("common/success", map);
    }

    @RequestMapping("/remove")
    public ModelAndView remove(@RequestParam(value = "categoryId", required = true) Integer categoryId,
                               Map<String, Object> map) {

        try {
            service.remove(categoryId);
        } catch (Exception exception) {
            map.put("msg", exception.getMessage());
            map.put("url", "/seller/product/index");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/seller/category/list");
        return new ModelAndView("common/success", map);
    }
}
