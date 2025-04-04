package com.star;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Classname: GatewayApplication
 * @Date: 2025/4/4 12:12
 * @Author: 聂建强
 * @Description:
 */
@EnableDiscoveryClient  // 开启nacos服务发现功能
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
