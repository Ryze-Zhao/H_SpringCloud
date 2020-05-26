package com.ryzezhao.springcloud.payment.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ryzezhao.springcloud.payment.entities.Payment;
import com.ryzezhao.springcloud.payment.mapper.PaymentMapper;
import com.ryzezhao.springcloud.payment.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;


@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池:  " + Thread.currentThread().getName() + "  paymentInfo_OK,id:  " + id + "  O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_Fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "6000")
    })
    @Override
    public String paymentInfo_TimeOut(Integer id) {
        //我们也可以人为制造异常，也是会调用fallbackMethod
//        int age = 10/0;
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:  " + Thread.currentThread().getName() + "  paymentInfo_TimeOut id:  " + id + "   O(∩_∩)O哈哈~";
    }

    public String paymentInfo_TimeOut_Fallback(Integer id) {
        return "线程池:  " + Thread.currentThread().getName() + "  8001系统繁忙或者运行报错，请稍后再试,id:  " + id + "    o(╥﹏╥)o呜呜";
    }


    //=====服务熔断
    /*
     * 下面的配置是，如果一段时间（我们这里设置为10000（10秒）），请求数超过10个,并且超时或异常多于60%，那么熔断器打开，会进入下一阶段：
     * 半开试探休眠时间内，会尝试放过去一部分流量进行试探，确定依赖服务是否恢复，如果异常或超时的请求数量仍多于50%(即失败比率超过50%)，
     * 则断路器跳闸并且进入FallBack逻辑，否则会重置开放服务（即恢复正常了）
     *
     * 注意：如果是时间范围内，实际请求个数小于我们设置的请求数，那么即使超时或异常多于我们设置的失败率，仍然不会跳闸
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallBack", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸
    })
    @Override
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        return Thread.currentThread().getName()  + "    调用成功，流水号: " + IdUtil.simpleUUID();
    }

    public String paymentCircuitBreakerFallBack(Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " + id;
    }
}
