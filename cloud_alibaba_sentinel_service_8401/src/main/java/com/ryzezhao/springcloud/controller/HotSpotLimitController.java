package com.ryzezhao.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 热点参数演示
 *
 * @author: HeHaoZhao
 * @date: 2020/6/19 19:44
 */
@RestController
@Slf4j
public class HotSpotLimitController {
    @GetMapping("/hotSpot")
//    1、该注解的vaule可以不跟接口名称，但是通常保持一致，便于区分。2、该注解的blockHandler必须与兜底方法的方法名保持一致
    @SentinelResource(value = "hotSpot", blockHandler = "dealHotSpot")
    public String hotSpot(@RequestParam(value = "p1", required = false) String p1,
                          @RequestParam(value = "p2", required = false) String p2) {
        log.info("------hotSpot");
        int i=0/10;
        return "------hotSpot";
    }

    public String dealHotSpot(String p1, String p2, BlockException exception) {
        //sentinel系统默认的提示：Blocked by Sentinel (flow limiting)
        log.info("------dealHotSpot,o(╥﹏╥)o");
        return "------dealHotSpot,o(╥﹏╥)o";
    }
}
