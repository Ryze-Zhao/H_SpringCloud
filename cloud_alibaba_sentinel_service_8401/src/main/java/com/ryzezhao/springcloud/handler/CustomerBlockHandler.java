package com.ryzezhao.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ryzezhao.springcloud.common.Result;

public class CustomerBlockHandler {
    public static Result customerHandlerException(BlockException exception) {
        return Result.error("按客戶自定义,Global HandlerException----1");
    }

    public static Result customerHandlerException2(BlockException exception) {
        return Result.error("按客戶自定义,Global HandlerException----2");
    }
}