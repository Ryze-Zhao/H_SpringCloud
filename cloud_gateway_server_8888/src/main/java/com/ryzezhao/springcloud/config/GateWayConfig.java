package com.ryzezhao.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 使用注入Bean，实现路由
 *
 * @return:
 * @author: HeHaoZhao
 * @date: 2020/5/28 19:08
 */
@Configuration
public class GateWayConfig {
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
//        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//
//        //可以自己写ID，也可以不写
//        routes.route("payment_routh", r -> r.path("/cloud/pay/payment/**").uri("lb://cloud-payment-service"))
//                .route(r -> r.path("/cloud/pay/payment/lb/**").uri("lb://cloud-payment-service"));
//        return routes.build();
//    }
}