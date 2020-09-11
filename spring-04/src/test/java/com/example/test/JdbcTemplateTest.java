package com.example.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class JdbcTemplateTest {

    @Test
    // 测试Spring产生的jdbc对象
    public void test2(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = app.getBean("jdbcTemplate", JdbcTemplate.class);
        int row = jdbcTemplate.update("insert into account values(?,?,?)", null, "lisa", 6000);
        System.out.println(row);
    }

    @Test
    public void test1() throws PropertyVetoException {
        // 创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/db2019?useSSL=false");
        dataSource.setUser("root");
        dataSource.setPassword("root");

        // 创建JdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        // 为JdbcTemplate设置数据源对象
        jdbcTemplate.setDataSource(dataSource);
        int row = jdbcTemplate.update("insert into account values(?,?,?)", null, "alice", 8000);
        System.out.println(row);
    }
}
