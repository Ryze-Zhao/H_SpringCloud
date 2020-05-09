package com.ryzezhao.springcloud.payment.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ryzezhao.springcloud.payment.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService extends IService<Payment> {
    Payment saveOrUpdatePayment(Payment payment);
    Payment getPaymentById(@Param("id") String id);
}
