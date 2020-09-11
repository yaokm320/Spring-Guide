package com.example.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;


@Configuration
// 标志着这是一个Spring配置类
@ComponentScan("com.example")
// 组件扫描，相当于 <context:component-scan base-package="com.example"/>
@Import({DataSourceConfiguration.class})
// 导入其他的配置类，相当于 <import resource=""></import>
public class SpringConfiguration {

}
