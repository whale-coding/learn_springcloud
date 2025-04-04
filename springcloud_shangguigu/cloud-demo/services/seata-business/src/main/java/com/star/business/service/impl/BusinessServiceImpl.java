package com.star.business.service.impl;

import com.star.business.feign.OrderFeignClient;
import com.star.business.feign.StorageFeignClient;
import com.star.business.service.BusinessService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class BusinessServiceImpl implements BusinessService {

    @Resource
    private StorageFeignClient storageFeignClient;

    @Resource
    private OrderFeignClient orderFeignClient;

    @Override
    public void purchase(String userId, String commodityCode, int orderCount) {
        //1. 扣减库存
        storageFeignClient.deduct(commodityCode,orderCount);
        //2. 创建订单
        orderFeignClient.create(userId,commodityCode,orderCount);
    }
}
