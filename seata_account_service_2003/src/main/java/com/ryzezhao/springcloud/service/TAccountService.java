package com.ryzezhao.springcloud.service;

import com.ryzezhao.springcloud.entities.TAccount;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

public interface TAccountService extends IService<TAccount> {

    /**
     * 扣减账户余额
     */
    boolean decrease(String userId, BigDecimal money);
}
