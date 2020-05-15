package com.ryzezhao.springcloud.payment.controller;

import com.ryzezhao.springcloud.payment.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/cloud/pay")
public class PaymentController
{
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul")
    public Result<Object> paymentConsul() {
        return Result.ok("Springcloud With Consul： " + serverPort + "\t" + UUID.randomUUID().toString());
    }
}
