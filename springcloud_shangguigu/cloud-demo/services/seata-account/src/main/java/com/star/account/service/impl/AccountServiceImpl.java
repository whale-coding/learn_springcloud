package com.star.account.service.impl;

import com.star.account.mapper.AccountTblMapper;
import com.star.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountTblMapper accountTblMapper;

    @Transactional  // 本地事务
    @Override
    public void debit(String userId, int money) {
        // 扣减账户余额
        accountTblMapper.debit(userId,money);
    }
}
