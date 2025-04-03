package com.star;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@EnableFeignClients  // 开启OpenFeign远程调用功能
@EnableDiscoveryClient  // 开启nacos服务发现功能
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }


    /**
     * 配置监听
     * 1.项目启动就监听配置文件变化
     * 2.发生变化后拿到变化值
     * 3.发送邮件通知
     * 项目一启动就会运行下面这个方法
     */
    @Bean
    ApplicationRunner applicationRunner(NacosConfigManager nacosConfigManager){
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                ConfigService configService = nacosConfigManager.getConfigService();  // 获取配置服务
                configService.addListener("service-order.properties", "DEFAULT_GROUP", new Listener() {
                    @Override
                    public Executor getExecutor() {
                        return Executors.newFixedThreadPool(4);
                    }

                    @Override
                    public void receiveConfigInfo(String configInfo) {
                        System.out.println("变化的配置信息:" + configInfo);

                        System.out.println("邮件通知...");
                    }
                });
                System.out.println("========================");
            }
        };
    }

}