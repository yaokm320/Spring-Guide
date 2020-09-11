package com.example.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TargetTest {
    public static void main(String[] args) {

        // 创建目标对象
        Target target = new Target();

        // 创建增强对象
        Advice advice = new Advice();

        // 返回值，就是动态生成的代理对象
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),     // 目标对象的类加载器
                target.getClass().getInterfaces(),      // 目标对象的接口的字节码对象数组
                new InvocationHandler() {
                    // 调用代理对象的任何方法，实质都是执行的invoke方法
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.before();
                        Object invoke = method.invoke(target, args);
                        advice.after();
                        return invoke;
                    }
                }
        );
        // 调用代理对象的方法
        proxy.save();
    }
}
