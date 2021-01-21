package com.xizi.controller;

import com.xizi.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/user/getproductInfo/rerestTemplate")
    public String  getProductInfo1(String productId){
        //1. 通过restTemplate直接调用
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://localhost:9098/product/find?id=" + productId, String.class);
        log.info("返回的信息:[{}]",forObject);
        return  forObject;
    }

    @GetMapping("/user/getproductInfo/rerestTemplateRibbon")
    public String  getProductInfo2(String productId){
        //2. restTemplate+ribbon 负载均衡客户端 DiscoveryClient  loadBalancerClient
//        List<ServiceInstance> products = discoveryClient.getInstances("products");
//        for (ServiceInstance product : products) {
//            log.info("服务地址：[{}]",product.getUri());
//        }
        ServiceInstance serviceInstance = loadBalancerClient.choose("products");
        log.info("当前处理服务负载均衡客户端主机为:[{}]",serviceInstance.getUri());

        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(serviceInstance.getUri()+"/product/find?id=" + productId, String.class);
        log.info("返回的信息:[{}]",forObject);
        return  forObject;
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/getproductInfo/restTemplateConfig")
    public String  getProductInfo3(String productId){
        //3.第三种注解方式 @Loadbalance
        String forObject = restTemplate.getForObject("http://products/product/find?id=" + productId, String.class);
        log.info("返回的信息:[{}]",forObject);
        return  forObject;
    }

    @Autowired
    private ProductClient productClient;

    @GetMapping("/user/getproductInfo/openfeign")
    public Map<String, Object>  getProductInfo4(String productId){
        Map<String, Object> map = productClient.find(productId);
        log.info("返回的信息:[{}]",map);
        return  map;
    }


}
