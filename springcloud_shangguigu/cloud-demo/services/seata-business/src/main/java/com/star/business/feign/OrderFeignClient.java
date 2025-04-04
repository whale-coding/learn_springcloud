package com.star.business.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Classname: OrderFeignClient
 * @Date: 2025/4/4 21:11
 * @Author: 聂建强
 * @Description:
 */
@FeignClient(value = "seata-order")
public interface OrderFeignClient {
    /**
     * 创建订单
     * @param userId
     * @param commodityCode
     * @param orderCount
     * @return
     */
    @GetMapping("/create")
    String create(@RequestParam("userId") String userId,
                  @RequestParam("commodityCode") String commodityCode,
                  @RequestParam("count") int orderCount);
}
