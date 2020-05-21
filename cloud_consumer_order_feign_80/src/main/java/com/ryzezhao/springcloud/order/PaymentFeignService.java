package com.ryzezhao.springcloud.order;

import com.ryzezhao.springcloud.common.Result;
import com.ryzezhao.springcloud.entities.PaymentVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {
    @GetMapping(value = "/cloud/pay/payment/{id}")
    Result<PaymentVO> getPaymentById(@PathVariable("id") String id);
    @GetMapping(value = "/cloud/pay/payment/feign/timeout")
    Result<String> paymentFeignTimeout();
}
