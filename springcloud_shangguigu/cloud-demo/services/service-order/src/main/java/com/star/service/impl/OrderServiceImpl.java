package com.star.service.impl;


import com.star.order.bean.Order;
import com.star.product.bean.Product;
import com.star.service.OrderService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname: OrderServiceImpl
 * @Date: 2025/4/3 10:11
 * @Author: 聂建强
 * @Description:
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private DiscoveryClient discoveryClient;  // 服务发现

    @Resource
    private RestTemplate restTemplate;  // 远程调用


    @Override
    public Order createOrder(Long productId, Long userId) {

        Product product = getProductFromRemote(productId);

        Order order = new Order();
        order.setId(1L);
        // 总金额
        order.setTotalAmount(product.getPrice().multiply(new BigDecimal(product.getNum())));
        order.setUserId(userId);
        order.setNickName("zhangsan");
        order.setAddress("北京");
        // TODO: 远程查询商品列表
        order.setProductList(Arrays.asList(product));

        return order;
    }

    // 远程获取商品列表
    private Product getProductFromRemote(Long productId){
        // 1.获取到商品服务所在的所有机器IP+port
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");

        ServiceInstance instance = instances.get(0);  // 获取第一个实例
        // 远程URL  http://localhost:9001/product/12
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/product/" + productId;
        log.info("远程请求：{}",url);

        // 2.给远程发送请求
        Product product = restTemplate.getForObject(url,Product.class);

        return product;
    }
}
