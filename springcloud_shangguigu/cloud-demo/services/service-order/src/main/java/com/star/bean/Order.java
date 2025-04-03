package com.star.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * @Classname: Order
 * @Date: 2025/4/3 10:07
 * @Author: 聂建强
 * @Description: 订单
 */
@Data
public class Order {
    private Long id;
    private BigDecimal totalAmount;  // 订单总金额
    private Long userId;
    private String nickName;
    private String address;
    private List<Objects> productList;  // 订单所包含的商品列表
}
