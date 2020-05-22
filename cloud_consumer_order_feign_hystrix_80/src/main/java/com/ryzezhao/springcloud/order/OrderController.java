package com.ryzezhao.springcloud.order;


import com.ryzezhao.springcloud.common.Result;
import com.ryzezhao.springcloud.entities.PaymentVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequestMapping("/cloud/consumer")
public class OrderController {
    @Autowired
    private PaymentFeignHystrixService paymentFeignHystrixService;

    @GetMapping("/hystrix/ok/{id}")
    public Result paymentInfo_OK(@PathVariable("id") String id) {
        Result<String> paymentVOResult = paymentFeignHystrixService.paymentInfo_OK(id);
        log.info("*****result: " + paymentVOResult.getResult());
        return paymentVOResult;
    }

    @GetMapping("/hystrix/timeout/{id}")
    public Result paymentInfo_TimeOut(@PathVariable("id") String id) {
//        int age = 10 / 0;
        Result<String> paymentVOResult = paymentFeignHystrixService.paymentInfo_TimeOut(id);
        log.info("*****result: " + paymentVOResult.getResult());
        return paymentVOResult;
    }
}
