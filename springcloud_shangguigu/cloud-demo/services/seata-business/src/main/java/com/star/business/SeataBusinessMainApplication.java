package com.star.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.star.business.feign")  // 开启feign客户端,扫描指定包下的FeignClient
@EnableDiscoveryClient
@SpringBootApplication
public class SeataBusinessMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataBusinessMainApplication.class, args);
    }
}
