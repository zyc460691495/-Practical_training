package com.example.redbag;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@Controller+@ResponseBody
//将此类交给spring管理
//返回给客户端响应 字符串直接返回 对象返回json
public class LuckyMoneyController {
    @Autowired
    private LuckMoneyRepo luckMoneyRepo;

    /**
     * 获取红包列表
     * @return
     */

//    @GetMapping("/list")
//    @PostMapping("/list")
    @RequestMapping("/list")
    public List<LuckyMoney> list(){
        return luckMoneyRepo.findAll();
    }
}
