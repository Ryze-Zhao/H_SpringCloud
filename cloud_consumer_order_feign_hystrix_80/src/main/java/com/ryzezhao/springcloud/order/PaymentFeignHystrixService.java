package com.ryzezhao.springcloud.order;

import com.ryzezhao.springcloud.common.Result;
import com.ryzezhao.springcloud.entities.PaymentVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Component
@FeignClient(value = "cloud-payment-hystrix-service")
public interface PaymentFeignHystrixService {
    @GetMapping(value = "/cloud/pay/payment/hystrix/ok/{id}")
    Result<String> paymentInfo_OK(@PathVariable("id") String id);

    @GetMapping(value = "/cloud/pay/payment/hystrix/timeout/{id}")
    Result<String> paymentInfo_TimeOut(@PathVariable("id") String id);
}
