package com.xizi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RefreshScope
public class TestController {

    @Value("${username}")
    private String name;

    @GetMapping("/test/test")
    public String test(){
        log.info("当前获取配置中name为:[{}]",name);
        return "当前获取配置中name为: "+name;
    }
}
