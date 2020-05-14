package com.ryzezhao.springcloud.order;


import com.ryzezhao.springcloud.order.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@Slf4j
@RequestMapping("/cloud/consumer")
public class OrderController {
    /** 服务提供者的URL*/
//    public static final String PAYMENT_URL = "http://localhost:8001";
    /** 服务提供者的spring.application.name，可从服务提供者的yml找到名称*/
    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/zk")
    public Result getPayment() {
        return restTemplate.getForObject(PAYMENT_URL + "/cloud/pay/payment/zk", Result.class);
    }
}
