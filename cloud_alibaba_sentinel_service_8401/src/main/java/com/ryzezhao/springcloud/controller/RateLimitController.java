package com.ryzezhao.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ryzezhao.springcloud.common.Result;
import com.ryzezhao.springcloud.entities.PaymentVO;
import com.ryzezhao.springcloud.handler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public Result byResource() {
        PaymentVO paymentVO = new PaymentVO();
        paymentVO.setId("6e9ff97a427a1afdabbe3c461b99bc1b");
        paymentVO.setSerial("cloud_alibaba_sentinel_service_8401");
        log.info("------byResource");
        return Result.ok("按资源名称限流测试OK", paymentVO);
    }

    /**
     * 作为blockHandler方法
     */
    public Result handleException(BlockException exception) {
        log.info("------handleException");
        return Result.error(exception.getClass().getCanonicalName() + "      服务不可用");
    }
}