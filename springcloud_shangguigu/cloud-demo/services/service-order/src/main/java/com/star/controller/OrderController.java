package com.star.controller;

import com.star.order.bean.Order;
import com.star.properties.OrderProperties;
import com.star.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.type.ReferenceType;

/**
 * @Classname: OrderController
 * @Date: 2025/4/3 10:05
 * @Author: 聂建强
 * @Description: 订单控制器
 */
// @RefreshScope  // 激活配置属性的刷新功能，用于nacos做配置中心，自动刷新配置
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    // @Value("${order.timeout}")
    // String orderTimeout;
    // @Value("${order.auto-confirm}")
    // String orderAutoConfirm;

    @Resource
    private OrderProperties orderProperties;

    // 测试nacos作为配置中心
    @GetMapping("/config")
    public String config(){
        return "order.timeout=" + orderProperties.getTimeout() +
                ": order.auto-confirm=" + orderProperties.getAutoConfirm() +
                ": order.db-url=" + orderProperties.getDbUrl();
    }

    // 创建订单
    @GetMapping("/create")
    public Order createOrder(@RequestParam("userId") Long userId,
                             @RequestParam("productId") Long productId){

        return orderService.createOrder(productId,userId);
    }
}
