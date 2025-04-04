package com.star.controller;

import com.star.product.bean.Product;
import com.star.service.ProductService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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
    public Product getProduct(@PathVariable("id") Long productId,
                              HttpServletRequest request){
        // 获取请求中的token，这里是openfeign请求拦截器中配置的请求头token
        String header = request.getHeader("X-Token");
        System.out.println("hello ... token=" + header);
        Product product = productService.getProductById(productId);

        // int i =10/0;

        // try {
        //     TimeUnit.SECONDS.sleep(2);
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // }

        return product;
    }
}
