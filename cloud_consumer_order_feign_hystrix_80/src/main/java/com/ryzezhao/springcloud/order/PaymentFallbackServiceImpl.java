package com.ryzezhao.springcloud.order;

import com.ryzezhao.springcloud.common.Result;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackServiceImpl implements PaymentFeignHystrixService {
    @Override
    public Result paymentInfo_OK(Integer id) {
        String result = "paymentInfo_OK服务消费者80：服务提供者8001系统繁忙或者本服务运行出错请检查,o(╥﹏╥)o呜呜" + id;
        return Result.error(result);
    }

    @Override
    public Result paymentInfo_TimeOut(Integer id) {
        String result = "paymentInfo_TimeOut服务消费者80：服务提供者8001系统繁忙或者本服务运行出错请检查,o(╥﹏╥)o呜呜" + id;
        return Result.error(result);
    }
}
