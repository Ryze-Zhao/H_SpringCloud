package com.ryzezhao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class StreamRabbitMQConsumer8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitMQConsumer8802.class, args);
    }
}
