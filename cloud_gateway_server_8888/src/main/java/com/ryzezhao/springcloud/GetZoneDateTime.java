package com.ryzezhao.springcloud;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * 获取时间断言的所需配置时间格式
 *
 * @author: HeHaoZhao
 * @date: 2020/5/29 20:01
 */
public class GetZoneDateTime {
    public static void main(String[] args) {
        //默认时区
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }
}


