package com.zyc.springbootsell.controller;

import com.zyc.springbootsell.dataobject.Seller;
import com.zyc.springbootsell.form.CategoryForm;
import com.zyc.springbootsell.form.SellerForm;
import com.zyc.springbootsell.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/seller/admin")
public class LoginController {

    @Autowired
    private SellerService service;


    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("admin/login");
    }

    @RequestMapping("/login")
    public ModelAndView check(@Valid SellerForm form){
//        System.out.println(form);
        Seller seller = service.checkUser(form.getUsername(), form.getPassword());
        System.out.println(seller);
        if (seller!=null){
            return new ModelAndView("admin/index");
        }else {
            return new ModelAndView("admin/login");
        }
    }
}
