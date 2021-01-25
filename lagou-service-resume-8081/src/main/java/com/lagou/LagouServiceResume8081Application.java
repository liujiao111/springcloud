package com.lagou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LagouServiceResume8081Application {
    public static void main(String[] args) {
        SpringApplication.run(LagouServiceResume8081Application.class, args);
    }
}
