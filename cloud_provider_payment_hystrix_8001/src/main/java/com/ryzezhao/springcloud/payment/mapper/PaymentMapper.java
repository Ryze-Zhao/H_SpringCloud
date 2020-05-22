package com.ryzezhao.springcloud.payment.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ryzezhao.springcloud.payment.entities.Payment;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {
}
