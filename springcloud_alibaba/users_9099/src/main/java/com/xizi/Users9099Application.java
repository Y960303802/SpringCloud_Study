package com.xizi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Users9099Application {

    public static void main(String[] args) {
        SpringApplication.run(Users9099Application.class, args);
    }

}
