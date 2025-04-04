package com.star.order.service.impl;

import com.star.order.bean.OrderTbl;
import com.star.order.mapper.OrderTblMapper;
import com.star.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderTblMapper orderTblMapper;

    @Override
    public OrderTbl create(String userId, String commodityCode, int orderCount) {
        //1、计算订单价格
        int orderMoney = calculate(commodityCode, orderCount);

        //TODO 2、扣减账户余额

        //3、保存订单
        OrderTbl orderTbl = new OrderTbl();
        orderTbl.setUserId(userId);
        orderTbl.setCommodityCode(commodityCode);
        orderTbl.setCount(orderCount);
        orderTbl.setMoney(orderMoney);

        orderTblMapper.insert(orderTbl);

        return orderTbl;
    }

    // 计算价格
    private int calculate(String commodityCode, int orderCount) {
        return 9*orderCount;
    }
}
