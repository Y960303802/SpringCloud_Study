package com.xizi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@Slf4j
public class UserController {


    //自定义随机主机
    public  String randomHost(){
        ArrayList<String> list   = new ArrayList<>();
        list.add("localhost:9997");
        list.add("localhost:9998");
        int i = new Random().nextInt(2);
        return list.get(i);
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate; //带有负载均衡的restTemplate客户端对象




    @GetMapping("/user/findAll")
    public String  findAll(){
//    public List<ServiceInstance>  findAll(){
//    public ServiceInstance  findAll(){
//        log.info("调用用户服务...");
//        //1.使用restTemplate调用商品服务
//        RestTemplate restTemplate = new RestTemplate();
////        String forObject = restTemplate.getForObject("http://localhost:9998/product/findAll", String.class);
//        String forObject = restTemplate.getForObject("http://"+randomHost()+"/product/findAll", String.class);
//        return forObject;

////        2. 使用ribbon调用方式
//        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("products");
//        for (ServiceInstance serviceInstance : serviceInstances) {
//            System.out.println(serviceInstance.getHost());
//            System.out.println(serviceInstance.getPort());
//        }
//        return  serviceInstances;

//        3. 根据负载均衡策略选取某一个服务调用
//        ServiceInstance product = loadBalancerClient.choose("products");//地址  轮询策略
//        log.info("服务主机:[{}]",product.getHost());
//        log.info("服务端口:[{}]",product.getPort());
//        log.info("服务地址:[{}]",product.getUri());
//        String url="http://"+product.getHost()+":"+product.getPort()+"/product/findAll";
//        String forObject = restTemplate.getForObject(url, String.class);
        String forObject = restTemplate.getForObject("http://products/product/findAll", String.class);
        return forObject;
//        return product;
    }
}