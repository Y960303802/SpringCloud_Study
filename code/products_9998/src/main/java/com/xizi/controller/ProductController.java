package com.xizi.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xizi.pojo.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class ProductController {

    @Value("${server.port}")
    private int port;


    //Get传参测试
    @GetMapping("/product/findOne")
    public Map<String,Object> findOne(@RequestParam("productId") String productId) throws Exception {
        log.info("商品服务,接收到的商品id为:[{}]",productId);
        Map<String, Object> map = new HashMap<>();
//        Thread.sleep(2000);
        map.put("productdId",productId);
        map.put("msg","根据商品id查询商品信息成功！");
        map.put("status",true);
        map.put("port", port);
        return map;
    }

    @GetMapping("/product/findAll")
    public Map<String,Object> findAll(){
        log.info("商品服务查询所有调用成功,当前服务端口:[{}]",port);
        Map<String, Object> map = new HashMap<>();
        map.put("msg","服务调用成功,服务提供端口为: "+port);
        map.put("status",true);
        return map;
    }

    @GetMapping("/product/break")
    @HystrixCommand(fallbackMethod = "testBreakFallBack")
//    @HystrixCommand(defaultFallback = "defaultBreakFallBack")
    public String testBreak(Integer id) {
        if(id<0){
            throw  new RuntimeException("非法参数,id不能小于0");
        }
        return "访问成功，当前查询的id为： "+id;
    }

    public String testBreakFallBack(Integer id){
        return "当前传入的参数id: "+id+",不是有效参数，触发熔断！";
    }

    public String defaultBreakFallBack(){
        return "当前触发熔断！";
    }

    //    Post传参测试
    @PostMapping("/product/update")
    //@RequestBody 将JSON格式对象转为对应的对象信息
    public Map<String,Object> update(@RequestBody Product product){
        log.info("商品服务,接收到的商品name为:[{}]",product);
        Map<String, Object> map = new HashMap<>();
        map.put("product",product);
        map.put("msg","添加商品信息成功！");
        map.put("status",true);
        map.put("port", port);
        return map;
    }

//    Post传参测试
    @PostMapping("/product/save")
    public Map<String,Object> save(@RequestParam("name") String name){
        log.info("商品服务,接收到的商品name为:[{}]",name);
        Map<String, Object> map = new HashMap<>();
        map.put("name",name);
        map.put("msg","添加商品信息成功！");
        map.put("status",true);
        map.put("port", port);
        return map;
    }






    @GetMapping("/product/showMsg")
    public String showMessage(){
        log.info("进入商品服务，展示商品---");
        return "进入商品服务，展示商品---服务提供端口为: "+port;
    }





}
