package com.star.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Classname: AccountFeignClient
 * @Date: 2025/4/4 21:17
 * @Author: 聂建强
 * @Description:
 */
@FeignClient(value = "seata-account")
public interface AccountFeignClient {
    /**
     * 扣减账户余额
     * @return
     */
    @GetMapping("/debit")
    String debit(@RequestParam("userId") String userId,
                 @RequestParam("money") int money);
}
