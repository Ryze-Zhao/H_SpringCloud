package com.ryzezhao.springcloud.controller;

import com.ryzezhao.springcloud.common.Result;
import com.ryzezhao.springcloud.entities.PaymentVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<String, PaymentVO> hashMap = new HashMap<>();

    //模拟数据源，不想搭建Mysql了
    static {
        hashMap.put("id1", new PaymentVO("serial1", "id1", null, null, null, null));
        hashMap.put("id2", new PaymentVO("serial2", "id2", null, null, null, null));
        hashMap.put("id3", new PaymentVO("serial3", "id3", null, null, null, null));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public Result paymentSQL(@PathVariable("id") String id) {
        PaymentVO payment = hashMap.get(id);
        return payment == null ? Result.error("不存在该ID信息") : Result.ok("信息服务端口为：" + serverPort, payment);
    }

}