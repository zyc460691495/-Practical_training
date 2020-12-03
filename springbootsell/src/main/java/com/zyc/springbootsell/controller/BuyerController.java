package com.zyc.springbootsell.controller;

import com.zyc.springbootsell.dataobject.*;
import com.zyc.springbootsell.exception.SellException;
import com.zyc.springbootsell.exception.passwordException;
import com.zyc.springbootsell.form.BuyerProductForm;
import com.zyc.springbootsell.form.SellerForm;
import com.zyc.springbootsell.repository.BuyerRepo;
import com.zyc.springbootsell.repository.OrderDteailRepo;
import com.zyc.springbootsell.repository.OrderMasterRepo;
import com.zyc.springbootsell.repository.ProductInfoRepo;
import com.zyc.springbootsell.services.BuyerService;
import com.zyc.springbootsell.services.SellerService;
import com.zyc.springbootsell.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/buyer/admin")
public class BuyerController {

    @Autowired
    private BuyerService service;
    @Autowired
    private BuyerRepo repo;
    @Autowired
    private ProductInfoRepo productInfoRepo;

    @Autowired
    private OrderDteailRepo orderDteailRepo;
    @Autowired
    private OrderMasterRepo orderMasterRepo;


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
            map.put("buyer", buyer);
            return new ModelAndView("buyer/index", map);
        } else {
            return new ModelAndView("buyer/login", map);
        }
    }

    @RequestMapping("/personInfo")
    public ModelAndView personInfo(@RequestParam(value = "username", required = true) String username,
                                   Map<String, Object> map) {

        Buyer buyer = repo.findOne(username);

        map.put("buyer", buyer);

        return new ModelAndView("buyer/personInfo", map);
    }

    @RequestMapping("/buy")
    public ModelAndView buy(@RequestParam(value = "username", required = true) String username,
                            Map<String, Object> map) {

        Buyer buyer = repo.findOne(username);
//        System.out.println(buyer);
        List<ProductInfo> productInfoList = productInfoRepo.findAll();
        map.put("productInfoList", productInfoList);
        map.put("buyer", buyer);
        return new ModelAndView("buyer/buy");
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request,
                             Map<String, Object> map) {
        String[] productPrices = request.getParameterValues("productPrice");
        String[] productNames = request.getParameterValues("productName");
        String[] productIcons = request.getParameterValues("productIcon");
        String[] productQuantities = request.getParameterValues("productQuantity");





        String[] productIds = request.getParameterValues("productId");

        String[] buyerPhones = request.getParameterValues("buyerPhone");
        String[] usernames = request.getParameterValues("username");
        String[] buyerAddresses = request.getParameterValues("buyerAddress");
        String[] buyerOpenIds = request.getParameterValues("buyerOpenId");

        try {
            int flag = 0;
            for (String quantities : productQuantities) {
                flag = flag + Integer.parseInt(quantities);
            }
            if (flag==0){
                throw new SellException("未选购商品",20);
            }
            //orderId
            String s = KeyUtil.genUniqueKey();
            //一个订单多个商品

            BigDecimal money = new BigDecimal(0);
            for (int i = 0; i < productQuantities.length; i++) {
                if (!productQuantities[i].equals("0")) {
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setOrderId(s);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    orderDetail.setProductId(productIds[i]);
                    orderDetail.setProductName(productNames[i]);
                    orderDetail.setProductIcon(productIcons[i]);
                    BigDecimal price = new BigDecimal(productPrices[i]);
                    orderDetail.setProductPrice(price);
                    Integer num = Integer.valueOf(productQuantities[i]);
                    orderDetail.setProductQuantity(num);

                    money = money.add(price.multiply(new BigDecimal(num)));

                    orderDteailRepo.save(orderDetail);
                }
            }
            for (int i = 0; i < productQuantities.length; i++) {
                if (!productQuantities[i].equals("0")) {
                    OrderMaster orderMaster = new OrderMaster();
                    orderMaster.setOrderId(s);
                    orderMaster.setBuyerPhone(buyerPhones[0]);
                    orderMaster.setBuyerOpenId(buyerOpenIds[0]);
                    orderMaster.setUserName(usernames[0]);
                    orderMaster.setBuyerAddress(buyerAddresses[0]);
                    orderMaster.setOrderAmount(money);
                    orderMasterRepo.save(orderMaster);
                }
            }
        } catch (Exception exception) {
            map.put("msg", exception.getMessage());
            map.put("url", "buy?username=" + usernames[0]);
            return new ModelAndView("common/error", map);
        }
        map.put("url", "buy?username=" + usernames[0]);
        return new ModelAndView("common/success", map);
    }

    @RequestMapping("/list")
    public ModelAndView list(@RequestParam(value = "username", required = true) String username,
                             Map<String, Object> map) {
        Buyer buyer = repo.findOne(username);
        List<OrderMaster> list = orderMasterRepo.findByUserName(username);

//        for (OrderMaster orderMaster:list){
//            System.out.println(orderMaster);
//        }
        map.put("orderMasterList", list);
        map.put("buyer", buyer);
        return new ModelAndView("buyer/list", map);
    }

    @RequestMapping("/update")
    public ModelAndView update(@RequestParam(value = "username", required = true) String username,
                               Map<String, Object> map) {

        Buyer buyer = repo.findOne(username);
        map.put("buyer", buyer);
        return new ModelAndView("buyer/update");
    }

    @RequestMapping("/renew")
    public ModelAndView renew(HttpServletRequest request,
                              Map<String, Object> map) {

        String[] buyerPhones = request.getParameterValues("buyerPhone");
        String[] buyerAddresses = request.getParameterValues("buyerAddress");
        String[] buyerOpenIds = request.getParameterValues("buyerOpenId");
        String[] usernames = request.getParameterValues("username");
        String[] userpasswords = request.getParameterValues("password");
        System.out.println(userpasswords[0] + userpasswords[1]);
//        System.out.println(usernames.length);
        try {
            if (!(userpasswords[0].equals(userpasswords[1]))) {
                throw new passwordException("两次密码不同", 2);
            }

            String[] passwords = request.getParameterValues("password");
            Buyer buyer = repo.findOne(usernames[0]);
            buyer.setBuyerPhone(buyerPhones[0]);
            buyer.setBuyerAddress(buyerAddresses[0]);
            buyer.setBuyerOpenId(buyerOpenIds[0]);
            buyer.setPassword(userpasswords[0]);
            repo.save(buyer);
            map.put("url", "/buyer/admin/personInfo?username=" + usernames[0]);
            return new ModelAndView("common/success", map);
        } catch (Exception exception) {
            map.put("msg", exception.getMessage());
            map.put("url", "/buyer/admin/personInfo?username=" + usernames[0]);
            return new ModelAndView("common/error", map);
        }
    }

}
