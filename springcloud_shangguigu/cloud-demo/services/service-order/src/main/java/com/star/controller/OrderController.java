package com.star.controller;

import com.star.bean.Order;
import com.star.service.OrderService;
import jakarta.annotation.Resource;
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
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    // 创建订单
    @GetMapping("/create")
    public Order createOrder(@RequestParam("userId") Long userId,
                             @RequestParam("productId") Long productId){

        return orderService.createOrder(productId,userId);
    }
}
