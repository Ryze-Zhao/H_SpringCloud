package com.ryzezhao.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 降级演示
 *
 * @author: HeHaoZhao
 * @date: 2020/6/17 19:29
 */
@RestController
@Slf4j
public class DegradeLimitController {
    @GetMapping("/testF")
    public String testF() {
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testF 测试RT");
        return "------testF";
    }

    @GetMapping("/testG")
    public String testG() {
        log.info("testG 测试异常比例");
        int i = 10/0;
        return "------testG 测试异常比例";
    }
}
