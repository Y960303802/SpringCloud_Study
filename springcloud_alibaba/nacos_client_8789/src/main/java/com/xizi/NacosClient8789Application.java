package com.xizi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient  //开启注册与发现
public class NacosClient8789Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosClient8789Application.class, args);
    }

}
