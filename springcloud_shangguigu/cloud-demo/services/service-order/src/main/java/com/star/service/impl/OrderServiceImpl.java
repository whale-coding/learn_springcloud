package com.star.service.impl;

import com.star.bean.Order;
import com.star.service.OrderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Classname: OrderServiceImpl
 * @Date: 2025/4/3 10:11
 * @Author: 聂建强
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public Order createOrder(Long productId, Long userId) {
        Order order = new Order();

        order.setId(1L);
        // TODO: 总金额
        order.setTotalAmount(new BigDecimal(0));
        order.setUserId(userId);
        order.setNickName("zhangsan");
        order.setAddress("北京");
        // TODO: 远程查询商品列表
        order.setProductList(null);

        return order;
    }
}
