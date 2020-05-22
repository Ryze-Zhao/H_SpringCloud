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

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        //int age = 10/0;
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:  " + Thread.currentThread().getName() + "  paymentInfo_TimeOut id:  " + id + "   O(∩_∩)O哈哈~" ;
    }
}
