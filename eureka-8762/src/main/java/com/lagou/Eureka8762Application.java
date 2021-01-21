package com.lagou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
// 声明本项⽬是⼀个Eureka服务
@EnableEurekaServer
public class Eureka8762Application {
    public static void main(String[] args) {
        SpringApplication.run(Eureka8762Application.class, args);
    }
}