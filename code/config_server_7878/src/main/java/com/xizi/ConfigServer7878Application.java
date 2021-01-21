package com.xizi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;


@ServletComponentScan(basePackages = "com.xizi.config")
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigServer7878Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer7878Application.class, args);
    }

}
