package com.example.redbag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    //只能get
//    @PostMapping
    //只能发送post
//    @RequestMapping
    //指定方法的请求地址

    public String sayHello(){
        return "hello springBoot";
    }
}
