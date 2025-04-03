package com.star.service.impl;

import com.star.product.bean.Product;
import com.star.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Classname: ProductServiceImpl
 * @Date: 2025/4/3 09:53
 * @Author: 聂建强
 * @Description:
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Product getProductById(Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setPrice(new BigDecimal("99"));
        product.setProductName("苹果-" + productId);
        product.setNum(2);

        return product;
    }
}
