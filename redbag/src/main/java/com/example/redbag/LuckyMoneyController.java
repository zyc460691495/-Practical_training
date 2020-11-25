package com.example.redbag;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
//@Controller+@ResponseBody
//将此类交给spring管理
//返回给客户端响应 字符串直接返回 对象返回json
@RequestMapping("/bag")
public class LuckyMoneyController {
    @Autowired
    private LuckMoneyRepo luckMoneyRepo;

//    @PostMapping("/list")
    @GetMapping("/list")
    public List<LuckyMoney> list() {
        return luckMoneyRepo.findAll();
    }

    @PostMapping("/post")
//    @RequestMapping("/post")
    public LuckyMoney postRedBag(@RequestParam(value = "producer", required = true) String producer,
                                 @RequestParam(value = "money", required = true) BigDecimal money) {
        LuckyMoney luckyMoney = new LuckyMoney();
        luckyMoney.setProducer(producer);
        luckyMoney.setMoney(money);
        return luckMoneyRepo.save(luckyMoney);
    }

    @GetMapping("/find/{id}")
    public LuckyMoney findById(@PathVariable("id") Integer id) {
//        Optional<LuckyMoney> byId = luckMoneyRepo.findById(id);
//        LuckyMoney luckyMoney=byId.get();
//        return luckyMoney;
        return luckMoneyRepo.findById(id).orElse(null);
    }
    @PutMapping("/put/{id}")
    public LuckyMoney put(@PathVariable("id")Integer id,
                          @RequestParam(value = "consumer") String consumer){
        Optional<LuckyMoney> byId = luckMoneyRepo.findById(id);
        if(byId.isPresent()){
            LuckyMoney luckyMoney=byId.get();
            luckyMoney.setConsumer(consumer);
            return luckMoneyRepo.save(luckyMoney);
        }
        return null;
    }

}
