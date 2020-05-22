package com.ryzezhao.springcloud.payment.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryzezhao.springcloud.payment.entities.Payment;
import com.ryzezhao.springcloud.payment.mapper.PaymentMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

public interface PaymentService extends IService<Payment> {
    String paymentInfo_OK(Integer id);
    String paymentInfo_TimeOut(Integer id);
}
