package com.xizi.controller;

import com.xizi.client.ProductClient;
import com.xizi.pojo.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class TestFeignController {

    @Autowired
    private ProductClient productClient;


    @GetMapping("/feign/findOne")
    public Map<String,Object> test3(String id){
        log.info("进入测试feign的GET方式传递参数...");
        Map<String, Object> map = productClient.findOne(id);
        log.info("调用商品服务返回的信息：[{}]",map);
        return map;
    }

    @GetMapping("/feign/test")
    public String test(){
        log.info("进入测试feign调用的方法...");
        String s = productClient.showMessage();
        log.info("调用商品服务返回的信息：[{}]",s);
        return s;
    }

    @GetMapping("/feign/findAll")
    public Map<String,Object> test2(){
        log.info("进入测试feign调用的方法...");
        Map<String, Object> map = productClient.findAll();
        log.info("调用商品服务返回的信息：[{}]",map);
        return map;
    }




    //测试参数post方式调用传参
    @GetMapping("/feign/save")
    public Map<String,Object> test4(String username){
        log.info("进入测试feign的Post方式传递参数...");
        Map<String, Object> map = productClient.save(username);
        log.info("调用商品服务返回的信息：[{}]",map);
        return map;
    }

    //测试参数post方式对象的参数传递
    @PostMapping("/feign/update")
    public Map<String,Object> test5(Product product){
        log.info("接收的商品信息:[{}]",product);
        Map<String, Object> map = productClient.update(product);
        log.info("调用商品服务返回的信息：[{}]",map);
        return map;
    }

}
