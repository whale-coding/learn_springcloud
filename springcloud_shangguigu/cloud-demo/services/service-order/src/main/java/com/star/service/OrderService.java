package com.star.service;

import com.star.bean.Order;

/**
 * @Classname: OrderService
 * @Date: 2025/4/3 10:10
 * @Author: 聂建强
 * @Description:
 */
public interface OrderService {

    Order createOrder(Long productId,Long userId);
}
