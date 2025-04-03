package com.star.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Classname: XTokenRequestInterceptor
 * @Date: 2025/4/3 18:38
 * @Author: 聂建强
 * @Description: 自定义openfeign的请求拦截器
 */
@Component  // 注入之后，OpenFeign会自动配置
public class XTokenRequestInterceptor implements RequestInterceptor {
    /**
     * 请求拦截器
     * @param requestTemplate 请求模版
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("XTokenRequestInterceptor......");
        // 给请求添加请求头
        requestTemplate.header("X-Token", UUID.randomUUID().toString());
    }
}
