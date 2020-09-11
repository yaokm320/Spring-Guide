package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


//<bean id="userService" class="com.example.service.impl.UserServiceImpl">
//<!-- 进行依赖注入，注意这里是引用数据类型 -->
//<property name="userDao" ref="userDao"></property>
//</bean>
//@Component("userService")
@Service("userService")
//@Scope("singleton")    // 设置下面的类是单例模式
//@Scope("prototype")    // 设置下面的类是原型的
public class UserServiceImpl implements UserService {

    @Value("${jdbc.driver}")
    // 使用SpEL表达式语言，spring expression language
    private String driver;

    @Autowired                  // 按照数据类型进行注入
    @Qualifier("userDao")       // 按照名称id进行注入，但是必须配合@Autowired一起使用
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println(driver);
        userDao.save();
    }
}
