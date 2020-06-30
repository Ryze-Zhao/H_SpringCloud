package com.ryzezhao.springcloud.controller;

import com.ryzezhao.springcloud.common.Result;
import com.ryzezhao.springcloud.entities.TOrder;
import com.ryzezhao.springcloud.service.TOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Autowired
    private TOrderService tOrderService;

    /**
     * 下订单
     */
    @PostMapping("/order/create")
    public Result create(@RequestBody TOrder tOrder) {
        return tOrderService.create(tOrder) ? Result.ok("订单创建成功！") : Result.error("订单创建失败！");
    }
}