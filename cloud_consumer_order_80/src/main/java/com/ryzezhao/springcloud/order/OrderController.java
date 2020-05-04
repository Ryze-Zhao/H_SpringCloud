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
    public static final String PAYMENT_URL = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/payment")
    public Result create(@RequestBody PaymenVO payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/cloud/pay/payment", payment, Result.class);
    }

    @GetMapping("/payment/{id}")
    public Result getPayment(@PathVariable("id") String id) {
        return restTemplate.getForObject(PAYMENT_URL + "/cloud/pay/payment/" + id, Result.class);
    }
}
