package com.star.order.service.impl;

import com.star.order.bean.OrderTbl;
import com.star.order.feign.AccountFeignClient;
import com.star.order.mapper.OrderTblMapper;
import com.star.order.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderTblMapper orderTblMapper;

    @Resource
    private AccountFeignClient accountFeignClient;

    @Transactional  // 本地事务
    @Override
    public OrderTbl create(String userId, String commodityCode, int orderCount) {
        //1、计算订单价格
        int orderMoney = calculate(commodityCode, orderCount);

        // 2、扣减账户余额
        accountFeignClient.debit(userId,orderMoney);

        //3、保存订单
        OrderTbl orderTbl = new OrderTbl();
        orderTbl.setUserId(userId);
        orderTbl.setCommodityCode(commodityCode);
        orderTbl.setCount(orderCount);
        orderTbl.setMoney(orderMoney);
        // 4.保存订单
        orderTblMapper.insert(orderTbl);

        // 模拟异常，用于测试事务是否能回滚
        int i = 10/0;

        return orderTbl;
    }

    // 计算价格
    private int calculate(String commodityCode, int orderCount) {
        return 9*orderCount;
    }
}
