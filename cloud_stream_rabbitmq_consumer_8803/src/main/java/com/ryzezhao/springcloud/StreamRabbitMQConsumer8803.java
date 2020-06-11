package com.ryzezhao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitMQConsumer8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitMQConsumer8803.class, args);
    }
}
