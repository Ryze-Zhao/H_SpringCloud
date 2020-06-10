package com.ryzezhao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitMQProvider8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitMQProvider8801.class, args);
    }
}
