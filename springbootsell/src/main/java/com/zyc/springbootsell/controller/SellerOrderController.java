package com.zyc.springbootsell.controller;


import com.zyc.springbootsell.dataobject.OrderDetail;
import com.zyc.springbootsell.dataobject.OrderMaster;
import com.zyc.springbootsell.dataobject.ProductCategory;
import com.zyc.springbootsell.dataobject.ProductInfo;
import com.zyc.springbootsell.exception.SellException;
import com.zyc.springbootsell.form.OrderForm;
import com.zyc.springbootsell.form.ProductForm;
import com.zyc.springbootsell.services.OrderDetailService;
import com.zyc.springbootsell.services.OrderMasterService;
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
@RequestMapping("/seller/order")
public class SellerOrderController {


    @Autowired
    OrderMasterService service;
    @Autowired
    OrderDetailService detailService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize",defaultValue = "2") Integer pageSize,
                             Map<String, Object> map) {
        Pageable pageable = new PageRequest(pageNum-1, pageSize);
        Page<OrderMaster> allPage = service.findAllPage(pageable);
        map.put("orderMasterPage", allPage);
        map.put("currentPage", pageNum);
        map.put("pageSize", pageSize);
        return new ModelAndView("order/list",map);
    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam(value = "orderId") String orderId,
                               Map<String,Object> map){
        try {
            List<OrderDetail> orderDetailList = detailService.findByOrderId(orderId);
            map.put("orderDetailList",orderDetailList);
            return new ModelAndView("order/detail",map);
        }catch (Exception exception){
            map.put("msg", exception.getMessage());
            map.put("url", "/seller/order/list");
            return new ModelAndView("common/error", map);
        }
    }



    @RequestMapping("/remove")
    public ModelAndView remove(@RequestParam(value = "orderId", required = true) String orderId,
                               Map<String, Object> map) {

        try {
            service.remove(orderId);
        } catch (Exception exception) {
            map.put("msg", exception.getMessage());
            map.put("url", "/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/seller/order/list");
        return new ModelAndView("common/success", map);
    }
}
