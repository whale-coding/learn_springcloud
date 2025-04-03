package com.star.feign.fallback;

import com.star.feign.ProductFeignClient;
import com.star.product.bean.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @Classname: ProductFeignClientFallback
 * @Date: 2025/4/3 20:53
 * @Author: 聂建强
 * @Description:  ProductFeignClient的兜底回调
 */
@Component  // 加入到spring容器中
public class ProductFeignClientFallback implements ProductFeignClient {
    @Override
    public Product getProductById(Long id) {
        System.out.println("兜底回调...");

        Product product = new Product();
        product.setId(id);
        product.setPrice(new BigDecimal(0));
        product.setProductName("未知商品");
        product.setNum(0);

        return product;
    }
}
