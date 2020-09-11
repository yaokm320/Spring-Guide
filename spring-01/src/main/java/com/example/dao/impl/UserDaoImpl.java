package com.example.dao.impl;

import com.example.dao.UserDao;
import com.example.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {

    private String username;
    private int age;

    private List<String> strList;
    private Map<String, User> userMap;
    private Properties properties;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void save() {
        System.out.println("UserDaoImpl running...");
        System.out.println(username);
        System.out.println(age);
        System.out.println(strList);
        System.out.println(userMap);
        System.out.println(properties);
    }
}
