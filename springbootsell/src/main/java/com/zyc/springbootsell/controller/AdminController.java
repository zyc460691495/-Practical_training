package com.zyc.springbootsell.controller;

import com.zyc.springbootsell.dataobject.*;
import com.zyc.springbootsell.exception.SellException;
import com.zyc.springbootsell.exception.passwordException;
import com.zyc.springbootsell.form.SellerForm;
import com.zyc.springbootsell.repository.*;
import com.zyc.springbootsell.services.BuyerService;
import com.zyc.springbootsell.services.OrderDetailService;
import com.zyc.springbootsell.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BuyerService service;
    @Autowired
    private BuyerRepo repo;
    @Autowired
    private ProductInfoRepo productInfoRepo;

    @Autowired
    private BuyerRepo buyerRepo;
    @Autowired
    private SellerRepo sellerRepo;

    @Autowired
    private OrderDteailRepo orderDteailRepo;
    @Autowired
    private OrderMasterRepo orderMasterRepo;

    @Autowired
    private OrderDetailService orderDetailService;

    @RequestMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("buyer/login");
    }

    @RequestMapping("/login")
    public ModelAndView check(@Valid SellerForm form,
                              Map<String, Object> map) {
//        System.out.println(form);
        Buyer buyer = service.checkUser(form.getUsername(), form.getPassword());
//        System.out.println(buyer);
        if (buyer != null) {
            map.put("admin", buyer);
            return new ModelAndView("admin/index", map);
        } else {
            return new ModelAndView("admin/login", map);
        }
    }

    @RequestMapping("/allOrder")
    public void listAllOrder(){
        List<OrderMaster> all = orderMasterRepo.findAll();
        for (OrderMaster orderMaster:all){
            System.out.println(orderMaster);
        }
    }

    @RequestMapping("/allBuyer")
    public void listAllBuyer(){
        List<Buyer> all = buyerRepo.findAll();
        for (Buyer buyer:all){
            System.out.println(buyer);
        }
    }
    @RequestMapping("/allSeller")
    public void listAllSeller(){
        List<Seller> all = sellerRepo.findAll();
        for (Seller seller:all){
            System.out.println(seller);
        }
    }

}
