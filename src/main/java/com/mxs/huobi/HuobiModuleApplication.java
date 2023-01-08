package com.mxs.huobi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HuobiModuleApplication {
    public static void main(String[] args) {
        SpringApplication.run(HuobiModuleApplication.class, args);
    }
}