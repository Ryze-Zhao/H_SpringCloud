package com.ryzezhao.springcloud.controller;

import com.ryzezhao.springcloud.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RestController
@Slf4j
@RequestMapping("/cloud/consumer")
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping(value = "/payment/nacos/{num}")
    public Result getPayment(@PathVariable("num") Integer num) {
        return restTemplate.getForObject(serverURL + "/cloud/pay/payment/nacos/" + num, Result.class);
    }
}
