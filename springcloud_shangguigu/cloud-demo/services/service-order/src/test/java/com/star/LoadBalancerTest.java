package com.star;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

/**
 * @Classname: LoadBalancerTest
 * @Date: 2025/4/3 11:30
 * @Author: 聂建强
 * @Description: 测试负债均衡LoadBalancer
 */
@SpringBootTest
public class LoadBalancerTest {

    @Resource
    private LoadBalancerClient loadBalancerClient;  // 负载均衡

    /**
     * 测试负载均衡
     */
    @Test
    public void testLoadBalancer(){
        ServiceInstance choose = loadBalancerClient.choose("service-product");
        System.out.println("choose = " + choose.getHost() + ":" + choose.getPort());

        choose = loadBalancerClient.choose("service-product");
        System.out.println("choose = " + choose.getHost() + ":" + choose.getPort());

        choose = loadBalancerClient.choose("service-product");
        System.out.println("choose = " + choose.getHost() + ":" + choose.getPort());

        choose = loadBalancerClient.choose("service-product");
        System.out.println("choose = " + choose.getHost() + ":" + choose.getPort());
    }
}
