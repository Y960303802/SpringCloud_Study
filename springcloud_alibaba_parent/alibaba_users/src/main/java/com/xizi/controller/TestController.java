package com.xizi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RefreshScope
public class TestController {


    @GetMapping("/user/test")
    public String test(){
        return "测试users";
    }
}
