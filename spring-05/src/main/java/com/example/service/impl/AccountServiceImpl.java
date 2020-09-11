package com.example.service.impl;

import com.example.dao.AccountDao;
import com.example.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String outMan, String inMan, double money) {
        accountDao.out(outMan,money);
        int a = 1/0;
        accountDao.in(inMan,money);
    }
}
