package com.star.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Classname: Product
 * @Date: 2025/4/3 09:50
 * @Author: 聂建强
 * @Description: 商品模型类
 */
@Data
public class Product {
    private Long id;
    private BigDecimal price;
    private String productName;
    private int num;
}
