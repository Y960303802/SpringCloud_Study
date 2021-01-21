package com.xizi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("products")
public interface ProductClient {

    @GetMapping("/product/find")
     Map<String,Object> find(@RequestParam("id") String id);


    }
