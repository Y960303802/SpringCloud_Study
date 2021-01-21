package com.xizi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //开启仪表盘
public class HystrixDashboard9990Application {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard9990Application.class, args);
    }

}
