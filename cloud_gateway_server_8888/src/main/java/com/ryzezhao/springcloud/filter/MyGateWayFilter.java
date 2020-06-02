package com.ryzezhao.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

@Component
@Slf4j
public class MyGateWayFilter implements GlobalFilter, Ordered {

    /**
     * 自定义拦截
     *
     * @param exchange
     * @param chain
     * @return: reactor.core.publisher.Mono<java.lang.Void>
     * @author: HeHaoZhao
     * @date: 2020/6/2 19:08
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("MyGateWayFilter启动，时间：{}", new Date());
        // 获取请求参数中叫name的参数（只取第一个）
        String uname = exchange.getRequest().getQueryParams().getFirst("name");
        if (StringUtils.isBlank(uname)) {
            log.info("MyGateWayFilter：检测到用户名是非法用户，o(╥﹏╥)o");
            //这里也可以使用我们自己
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * 控制该拦截器的拦截优先级，数值越大，优先级越低。
     *
     * @param
     * @return: int
     * @author: HeHaoZhao
     * @date: 2020/6/2 19:06
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
