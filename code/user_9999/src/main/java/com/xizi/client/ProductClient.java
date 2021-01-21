package com.xizi.client;

import com.xizi.fallback.ProductClientFallBack;
import com.xizi.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

//作用标识当前接口是一个feign的组件 value 是服务名字
@FeignClient(value = "products",fallback = ProductClientFallBack.class)
//@FeignClient(value = "products")
public interface ProductClient {

    //展示商品信息
    @GetMapping("/product/showMsg")
    String showMessage();

    //查询所有商品信息
    @GetMapping("/product/findAll")
    Map<String,Object> findAll();

    //根据商品id查询商品信息
    @GetMapping("/product/findOne")
    //注意使用openfeign 的GET方式传递参数 参数变量必须通过@RequestParam注解进行修饰
    Map<String,Object> findOne(@RequestParam("productId") String productId);

    @PostMapping("/product/save")
    //注意使用openfeign 的Post方式传递参数 参数变量必须通过@RequestParam注解进行修饰
    Map<String,Object> save(@RequestParam("name") String name);

    @PostMapping("/product/update")
    //使用openfeign的post方式传递对象信息
    //要求服务提供方和服务调用方都是用@RequestBody 进行参数声明
    Map<String,Object> update(@RequestBody Product product);
}
