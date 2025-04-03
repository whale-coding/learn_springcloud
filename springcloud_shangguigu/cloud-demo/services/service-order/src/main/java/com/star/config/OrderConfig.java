package com.star.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname: OrderConfig
 * @Date: 2025/4/3 11:11
 * @Author: 聂建强
 * @Description:
 */
@Configuration
public class OrderConfig {

    @LoadBalanced  // 注解式负载均衡：标注了这个注解，restTemplate就自带负载均衡功能了
    @Bean
    public RestTemplate restTemplate(){  // 远程调用
        return new RestTemplate();
    }
}
