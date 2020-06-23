package com.ryzezhao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderPayment9004 {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderPayment9004.class, args);
    }
}