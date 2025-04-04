package com.star.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.star.order.bean.Order;
import com.star.properties.OrderProperties;
import com.star.service.OrderService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.type.ReferenceType;

/**
 * @Classname: OrderController
 * @Date: 2025/4/3 10:05
 * @Author: 聂建强
 * @Description: 订单控制器
 */
@RequestMapping("/api/order")
@Slf4j
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

    // 秒杀
    @GetMapping("/seckill")
    @SentinelResource(value = "seckill-order", fallback = "seckillFallback")
    public Order seckill(@RequestParam(value ="userId", required = false) Long userId,
                             @RequestParam(value = "productId", defaultValue = "1000") Long productId){
        Order order = orderService.createOrder(productId,userId);
        order.setId(Long.MAX_VALUE);

        return order;
    }

    // 秒杀资源的兜底回调
    // 注意点：使用fallback指定兜底回调时，需要使用的是Throwable e ； 使用blockHandler指定兜底回调时，需要使用的是BlockException e
    public Order seckillFallback(Long userId, Long productId, Throwable e){
        System.out.println("seckillFallback...");
        Order order = new Order();
        order.setId(productId);
        order.setUserId(userId);
        order.setAddress("异常信息：" + e.getClass());

        return order;
    }

    @GetMapping("/writeDb")
    public String writeDb(){
        return "writeDb success...";
    }

    @GetMapping("/readDb")
    public String readDb(){
        log.info("readDb...");
        return "readDb success...";
    }
}
