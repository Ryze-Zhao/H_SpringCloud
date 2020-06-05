package com.ryzezhao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
//表明是配置服务
@EnableConfigServer
public class ConfigServer3300 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer3300.class, args);
    }
}
