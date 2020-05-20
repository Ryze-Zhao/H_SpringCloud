package com.ryzezhao.springcloud.order;


import com.ryzezhao.springcloud.order.common.Result;
import com.ryzezhao.springcloud.order.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/cloud/consumer")
public class OrderController {
    /** 服务提供者的URL*/
//    public static final String PAYMENT_URL = "http://localhost:8001";
    /**
     * 服务提供者的spring.application.name，可从服务提供者的yml找到名称
     */
    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @Autowired
    private LoadBalancer loadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;
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

    @GetMapping(value = "/payment/lb")
    public Result getPaymentLB() {
//        服务提供者的名称
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }
        //使用自定义的接口
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        //服务提供者的controller路径
        return restTemplate.getForObject(uri + "/cloud/pay/payment/lb", Result.class);
    }
}
