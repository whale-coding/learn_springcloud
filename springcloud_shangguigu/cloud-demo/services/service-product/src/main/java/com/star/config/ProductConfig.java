package com.star.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname: ProductConfig
 * @Date: 2025/4/3 11:13
 * @Author: 聂建强
 * @Description:
 */
@Configuration
public class ProductConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
