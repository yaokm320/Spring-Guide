package com.example.ssm.test;


import com.example.ssm.pojo.Item;
import com.example.ssm.service.ItemService;
import com.example.ssm.service.ItemServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml", "classpath:applicationContext-service.xml"})
public class SpringMybatisTest {

    @Autowired
    @Qualifier("itemService")
    // 使用注解方式注入bean使用的是JDK的动态代理机制，而JDK的动态代理是不支持类注入的，只支持接口注入
    // 使用xml配置文件形式的可以支持类注入
    private ItemService itemService;

    @Test
    public void test1(){
        Item item = itemService.findById(1);
        System.out.println(item);
    }
}
