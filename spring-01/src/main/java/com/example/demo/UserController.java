package com.example.demo;

import com.example.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
        // 直接通过实例化UserServiceImpl的方式获取对象
//        UserService userService = new UserServiceImpl();
//        userService.save();

        // 通过Spring容器获取对象
        // 首先获取service对象，然后service对象调用dao对象
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userServiceImpl = app.getBean("userServiceImpl", UserServiceImpl.class);
        userServiceImpl.save();
    }
}
