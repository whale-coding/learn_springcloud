package com.star.config;

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

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
