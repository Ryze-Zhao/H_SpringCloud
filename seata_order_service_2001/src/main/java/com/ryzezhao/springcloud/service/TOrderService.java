package com.ryzezhao.springcloud.service;

import com.ryzezhao.springcloud.entities.TOrder;
import com.baomidou.mybatisplus.extension.service.IService;
public interface TOrderService extends IService<TOrder>{


    boolean create(TOrder tOrder);
}
