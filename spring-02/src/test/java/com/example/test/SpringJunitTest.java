package com.example.test;


import com.example.config.SpringConfiguration;
import com.example.dao.UserDao;
import com.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
// 添加Spring-test运行时
//@ContextConfiguration("classpath:applicationContext.xml")
// 使用配置文件的形式
@ContextConfiguration(classes = {SpringConfiguration.class})
// 使用注解的形式
public class SpringJunitTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private DataSource dataSource;

    @Test
    public void test1() throws SQLException {
        userDao.save();
        System.out.println(dataSource.getConnection());
    }
}
