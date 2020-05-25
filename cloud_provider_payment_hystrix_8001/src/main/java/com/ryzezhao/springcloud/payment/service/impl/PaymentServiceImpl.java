package com.ryzezhao.springcloud.payment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ryzezhao.springcloud.payment.entities.Payment;
import com.ryzezhao.springcloud.payment.mapper.PaymentMapper;
import com.ryzezhao.springcloud.payment.service.PaymentService;
import org.springframework.stereotype.Service;

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
}
