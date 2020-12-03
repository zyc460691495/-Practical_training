package com.zyc.springbootsell.controller;

import com.zyc.springbootsell.dataobject.ProductCategory;
import com.zyc.springbootsell.dataobject.ProductInfo;
import com.zyc.springbootsell.exception.SellException;
import com.zyc.springbootsell.form.ProductForm;
import com.zyc.springbootsell.services.CategoryService;
import com.zyc.springbootsell.services.ProductService;
import com.zyc.springbootsell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/product")
public class SellerProductController {

    @Autowired
    ProductService service;
    @Autowired
    CategoryService categoryService;


    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize",defaultValue = "2") Integer pageSize,
                             Map<String, Object> map) {
        Pageable pageable = new PageRequest(pageNum-1, pageSize, Sort.Direction.ASC,"productStatus");
        Page<ProductInfo> allPage = service.findAllPage(pageable);
        map.put("productInfoPage", allPage);
        map.put("currentPage", pageNum);
        map.put("pageSize", pageSize);
        return new ModelAndView("product/list",map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId",required = false) String productId,
                              Map<String,Object> map){
        if (!StringUtils.isEmpty(productId)){
            ProductInfo productInfo = service.findOne(productId);
            map.put("productInfo",productInfo);
        }
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList",categoryList);

        return new ModelAndView("product/index");
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm form,
                             BindingResult result,
                             Map<String,Object> map){

        ProductInfo productInfo = new ProductInfo();
        try {
            if (!StringUtils.isEmpty(form.getProductId())){
                //修改
                productInfo=service.findOne(form.getProductId());
            }else {
                form.setProductId(KeyUtil.genUniqueKey());
            }
//            System.out.println(form.toString());
            BeanUtils.copyProperties(form,productInfo);
//            productInfo.setCategoryType(form.getCategoryType());
//            System.out.println(productInfo.toString());
            service.save(productInfo);
        }catch (SellException exception){
            map.put("msg",exception.getMessage());
            map.put("url","/seller/product/index");
            return new ModelAndView("common/error",map);
        }
        map.put("url", "/seller/product/list");
        return new ModelAndView("common/success",map);
    }

    @RequestMapping("/updateSale")
    public ModelAndView updateSale(@RequestParam(value = "productId",required = true) String productId,
                                     Map<String,Object> map){
        try {
            ProductInfo productInfo = service.findOne(productId);
            if (productInfo.getProductStatus()==0){
                //在架->下架
                service.offSale(productId);
            }else {
                service.onSale(productId);
            }
        } catch (Exception exception) {
            map.put("msg", exception.getMessage());
            map.put("url", "/seller/product/index");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/seller/product/list");
        return new ModelAndView("common/success",map);
    }

}
