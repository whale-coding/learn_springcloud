package com.star.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Classname: RtGlobalFilter
 * @Date: 2025/4/4 13:34
 * @Author: 聂建强
 * @Description: 自定义GlobalFilter
 * 实现的功能：记录请求的RT时间=请求响应时间-请求开始时间
 */
@Component
@Slf4j
public class RtGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        String uri = request.getURI().toString();
        long start = System.currentTimeMillis();
        log.info("请求【{}】开始：时间：{}",uri,start);
        //========================以上是前置逻辑=========================

        // filter逻辑
        Mono<Void> filter = chain.filter(exchange)
                .doFinally((result)->{
                    //=======================以下是后置逻辑=========================
                    long end = System.currentTimeMillis();
                    log.info("请求【{}】结束：时间：{}，耗时：{}ms",uri,end,end-start);
                }); //放行   10s

        return filter;
    }

    // 重写自定义执行顺序方法，返回数字越小，优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}
