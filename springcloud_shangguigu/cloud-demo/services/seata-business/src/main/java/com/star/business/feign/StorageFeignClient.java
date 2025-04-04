package com.star.business.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Classname: StorageFeignClient
 * @Date: 2025/4/4 21:10
 * @Author: 聂建强
 * @Description:
 */
@FeignClient(value = "seata-storage")
public interface StorageFeignClient {
    /**
     * 扣减库存
     * @param commodityCode
     * @param count
     * @return
     */
    @GetMapping("/deduct")
    String deduct(@RequestParam("commodityCode") String commodityCode,
                  @RequestParam("count") Integer count);
}
