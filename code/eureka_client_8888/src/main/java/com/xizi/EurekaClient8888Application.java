package com.xizi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//开启eureka客户端
@EnableEurekaClient
public class EurekaClient8888Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient8888Application.class, args);
    }

}
