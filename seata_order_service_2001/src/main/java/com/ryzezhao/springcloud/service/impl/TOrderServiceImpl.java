package com.ryzezhao.springcloud.service.impl;


import com.ryzezhao.springcloud.remote.TAccountService;
import com.ryzezhao.springcloud.remote.TStorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryzezhao.springcloud.mapper.TOrderMapper;
import com.ryzezhao.springcloud.entities.TOrder;
import com.ryzezhao.springcloud.service.TOrderService;

@Service
@Slf4j
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements TOrderService {

    @Resource
    private TStorageService tStorageService;
    @Resource
    private TAccountService tAccountService;

    @Override
    @GlobalTransactional(name = "gt-create-order",rollbackFor = Exception.class)
    public boolean create(TOrder order) {
        log.info("----->开始新建订单");
        //1 新建订单
        order.setStatus(0);
        this.saveOrUpdate(order);

        //2 扣减库存
        log.info("----->订单微服务开始调用库存，做扣减Count");
        tStorageService.decrease(order.getProductId(), order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");

        //3 扣减账户
        log.info("----->订单微服务开始调用账户，做扣减Money");
        tAccountService.decrease(order.getUserId(), order.getMoney().multiply(new BigDecimal(order.getCount())));
        log.info("----->订单微服务开始调用账户，做扣减end");

        //4 修改订单状态，从零到1,1代表已经完成
        log.info("----->修改订单状态开始");
        order.setStatus(1);

        log.info("----->修改订单状态结束");

        log.info("----->下订单结束了，O(∩_∩)O哈哈~");
        return this.saveOrUpdate(order);
    }
}
