package com.star.controller;

import com.star.product.bean.Product;
import com.star.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname: ProductController
 * @Date: 2025/4/3 09:42
 * @Author: 聂建强
 * @Description: 商品控制器
 */
@RestController
public class ProductController {

    @Resource
    private ProductService productService;

    // 根据商品ID查询商品信息
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") Long productId){
        System.out.println("hello");
        return productService.getProductById(productId);
    }
}
