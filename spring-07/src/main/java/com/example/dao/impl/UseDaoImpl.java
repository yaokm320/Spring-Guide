package com.example.dao.impl;

import com.example.dao.UserDao;

public class UseDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save runing ...");
    }
}
