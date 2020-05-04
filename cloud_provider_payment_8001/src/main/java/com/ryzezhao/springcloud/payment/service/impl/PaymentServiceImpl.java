package com.ryzezhao.springcloud.payment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryzezhao.springcloud.payment.mapper.PaymentMapper;
import com.ryzezhao.springcloud.payment.entities.Payment;
import com.ryzezhao.springcloud.payment.service.PaymentService;
import org.springframework.stereotype.Service;


@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {
    @Override
    public Payment saveOrUpdatePayment(Payment payment) {
        boolean saveOrUpdate = this.saveOrUpdate(payment);
        return this.getById(payment.getId());
    }
    @Override
    public Payment getPaymentById(String id) {
        return this.getById(id);
    }
}
