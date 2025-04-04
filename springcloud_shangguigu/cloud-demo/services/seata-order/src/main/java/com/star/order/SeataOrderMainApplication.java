package com.star.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableFeignClients(basePackages = "com.star.order.feign")  // 开启feign客户端,扫描指定包下的FeignClient
@EnableTransactionManagement  // 开启事务管理
@MapperScan("com.star.order.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class SeataOrderMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMainApplication.class, args);
    }


}
