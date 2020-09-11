package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.service.UserService;


public class UserServiceImpl implements UserService {

    private UserDao userDao;

    // 有参构造器
    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    // 无参构造器
    public UserServiceImpl(){
    }

    // set方法
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save();
    }
}
