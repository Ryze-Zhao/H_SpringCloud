package com.ryzezhao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboard18001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard18001.class, args);
    }
}
