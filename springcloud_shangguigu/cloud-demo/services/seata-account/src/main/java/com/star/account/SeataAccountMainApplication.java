package com.star.account;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@MapperScan("com.star.account.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class SeataAccountMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccountMainApplication.class, args);
    }
}
