package com.ryzezhao.springcloud.controller;


import com.ryzezhao.springcloud.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequestMapping("/cloud/pay")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{num}")
    public Result getPayment(@PathVariable("num") Integer num) {
        String result = "cloud-alibaba-nacos-provider-payment-service：Port：" + serverPort + "       id：" + num;
        log.info(result);
        return Result.ok("成功", result);
    }
}

