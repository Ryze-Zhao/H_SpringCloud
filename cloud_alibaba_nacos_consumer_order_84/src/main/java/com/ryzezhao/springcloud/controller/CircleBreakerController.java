package com.ryzezhao.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ryzezhao.springcloud.common.Result;
import com.ryzezhao.springcloud.entities.PaymentVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    private String SERVICE_URL;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback") //没有配置
//    @SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback只负责业务异常
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler只负责sentinel控制台配置违规
//    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler")//同时配置fallback、blockHandler
    //配置fallback例外项目
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler",exceptionsToIgnore = {IllegalArgumentException.class})
    public Result fallback(@PathVariable String id) {
        Result result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, Result.class, id);
        if ("id4".equals(id)) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        } else if (result.getResult() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return result;
    }
    //本例是fallback
    public Result handlerFallback(@PathVariable String id,Throwable e) {
        return Result.error(444,"兜底异常handlerFallback,exception内容："+e.getMessage());
    }
    //本例是blockHandler
    public Result blockHandler(@PathVariable  String id, BlockException blockException) {
        return Result.error(445,"lockHandler-sentinel限流,无此流水: blockException："+blockException.getMessage());
    }
}