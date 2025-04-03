package com.star.service;


import com.star.product.bean.Product;

/**
 * @Classname: ProductService
 * @Date: 2025/4/3 09:53
 * @Author: 聂建强
 * @Description:
 */
public interface ProductService {
    Product getProductById(Long productId);
}
