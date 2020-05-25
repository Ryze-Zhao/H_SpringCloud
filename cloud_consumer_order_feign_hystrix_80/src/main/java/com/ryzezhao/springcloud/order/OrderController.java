package com.ryzezhao.springcloud.order;


import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ryzezhao.springcloud.common.Result;
import com.ryzezhao.springcloud.entities.PaymentVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "payment_Global_FallBack")
@RequestMapping("/cloud/consumer")
public class OrderController {
    @Autowired
    private PaymentFeignHystrixService paymentFeignHystrixService;

    @GetMapping("/hystrix/ok/{id}")
    public Result paymentInfo_OK(@PathVariable("id") Integer id) {
        Result<String> paymentVOResult = paymentFeignHystrixService.paymentInfo_OK(id);
        log.info("*****result: " + paymentVOResult.getResult());
        return paymentVOResult;
    }

/*    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_Fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @HystrixCommand*/
    @GetMapping("/hystrix/timeout/{id}")
    public Result paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        //我们也可以人为制造异常，也是会调用fallbackMethod
//        int age = 10/0;
        Result<String> paymentVOResult = paymentFeignHystrixService.paymentInfo_TimeOut(id);
        log.info("*****result: " + paymentVOResult.getResult());
        return paymentVOResult;
    }

//    public Result paymentInfo_TimeOut_Fallback(Integer id) {
//        String result = "服务消费者80：服务提供者8001系统繁忙或者本服务运行出错请检查,o(╥﹏╥)o呜呜" + id;
//        return Result.error(result);
//    }
//
//    public Result payment_Global_FallBack() {
//        return Result.error("Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~");
//    }
}
