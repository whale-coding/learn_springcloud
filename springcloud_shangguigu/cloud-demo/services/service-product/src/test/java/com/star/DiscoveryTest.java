package com.star;

import com.alibaba.cloud.nacos.discovery.NacosDiscoveryClient;
import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import com.alibaba.nacos.api.exception.NacosException;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import javax.sound.sampled.Port;
import java.util.List;

/**
 * @Classname: DiscoveryTest
 * @Date: 2025/4/2 21:44
 * @Author: 聂建强
 * @Description: 测试nacos的服务发现功能
 */
@SpringBootTest
public class DiscoveryTest {

    @Resource
    private DiscoveryClient discoveryClient;  // Spring家的标准规范，无论哪个注册中心都可以用该API

    @Resource
    private NacosServiceDiscovery nacosServiceDiscovery;  // nacos提供的API，只适用于nacos这个注册中心

    /***
     * 测试DiscoveryClient的使用
     */
    @Test
    public void testDiscoveryClient(){
        // 获取服务
        for (String service : discoveryClient.getServices()){
            System.out.println("service = "+ service);
            // 获取ip+port
            List<ServiceInstance> instances = discoveryClient.getInstances(service);  // 获取服务的实例列表
            for (ServiceInstance instance : instances){
                System.out.println("ip:"+instance.getHost()+ ":"+ "port = "+ instance.getPort());
            }
        }
    }

    /***
     * 测试NacosServiceDiscovery的使用
     */
    @Test
    public void testNacosServiceDiscovery() throws NacosException {
        // 获取服务
        for (String service : nacosServiceDiscovery.getServices()){
            System.out.println("service = "+ service);
            // 获取ip+port
            List<ServiceInstance> instances = nacosServiceDiscovery.getInstances(service);  // 获取服务的实例列表
            for (ServiceInstance instance : instances){
                System.out.println("ip:"+instance.getHost()+ ":"+ "port = "+ instance.getPort());
            }
        }
    }
}
