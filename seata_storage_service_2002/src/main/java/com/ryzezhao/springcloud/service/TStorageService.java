package com.ryzezhao.springcloud.service;

import com.ryzezhao.springcloud.entities.TStorage;
import com.baomidou.mybatisplus.extension.service.IService;
public interface TStorageService extends IService<TStorage>{


    /**
     * 扣减库存
     */
    boolean decrease(String productId, Integer count);
}
