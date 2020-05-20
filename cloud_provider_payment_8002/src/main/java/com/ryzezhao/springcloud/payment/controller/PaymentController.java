package com.ryzezhao.springcloud.payment.controller;

import com.ryzezhao.springcloud.payment.service.PaymentService;
import com.ryzezhao.springcloud.payment.common.HttpStatusConstant;
import com.ryzezhao.springcloud.payment.common.Result;
import com.ryzezhao.springcloud.payment.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/cloud/pay")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment")
    public Result saveOrUpdatePayment(@RequestBody Payment payment) {
        payment=paymentService.saveOrUpdatePayment(payment);
        if (null!=payment) {
            log.info("*****插入或修改结果：" + payment);
            return Result.ok("插入或修改数据成功,serverPort: " + serverPort, payment);
        } else {
            return Result.error(HttpStatusConstant.SC_NO_RESPONSE_444, "插入或修改数据失败");
        }
    }

    @GetMapping(value = "/payment/{id}")
    public Result getPaymentById(@PathVariable("id") String id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return Result.ok("查询成功,serverPort:  " + serverPort, payment);
        } else {
            return Result.error(HttpStatusConstant.SC_NO_RESPONSE_444, "没有对应记录,查询ID: " + id);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("已有服务: " + element);
            List<ServiceInstance> instances = discoveryClient.getInstances(element);
            for (ServiceInstance instance : instances) {
                log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
            }
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public Result getPaymentLB() {
        return Result.ok("成功", serverPort);
    }
}


//
//    @GetMapping(value = "/payment/feign/timeout")
//    public String paymentFeignTimeout() {
//        // 业务逻辑处理正确，但是需要耗费3秒钟
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return serverPort;
//    }
//
//    @GetMapping("/payment/zipkin")
//    public String paymentZipkin() {
//        return "hi ,i'am paymentzipkin server fall back，welcome to atguigu，O(∩_∩)O哈哈~";
//    }

