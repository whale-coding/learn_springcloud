package com.star.feign;

import com.star.feign.fallback.ProductFeignClientFallback;
import com.star.product.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Classname: ProductFeignClient
 * @Date: 2025/4/3 16:44
 * @Author: 聂建强
 * @Description: 商品服务的OpenFeign客户端
 */
// value指定远程调用的服务名，fallback指定调用失败之后的兜底回调
@FeignClient(value = "service-product", fallback = ProductFeignClientFallback.class)  // 声明这是一个OpenFeign客户端,value指定要远程调用的微服务的名字
public interface ProductFeignClient {

    // mvc注解的两套使用逻辑：
    // 1、标注在Controller上，是接受这样的请求
    // 2、标注在FeignClient上，是发送这样的请求

    /**
     * 根据id获取商品信息
     * @param id 商品id
     * @return 商品信息
     */
    @GetMapping("/product/{id}")
    Product getProductById(@PathVariable("id") Long id);
}
