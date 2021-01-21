package com.xizi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Products9098Application {

    public static void main(String[] args) {
        SpringApplication.run(Products9098Application.class, args);
    }

}
