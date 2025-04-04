package com.star.storage.service.impl;

import com.star.storage.mapper.StorageTblMapper;
import com.star.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    StorageTblMapper storageTblMapper;

    @Transactional  // 本地事务
    @Override
    public void deduct(String commodityCode, int count) {
        storageTblMapper.deduct(commodityCode, count);
        if (count == 5){
            throw new RuntimeException("库存不足");
        }
    }
}
