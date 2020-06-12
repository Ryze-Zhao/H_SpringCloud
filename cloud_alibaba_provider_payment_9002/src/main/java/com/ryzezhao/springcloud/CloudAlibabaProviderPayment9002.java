package com.ryzezhao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaProviderPayment9002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaProviderPayment9002.class, args);
    }
}
