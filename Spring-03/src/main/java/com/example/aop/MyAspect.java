package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

    // 前置通知
    public void before(){
        System.out.println("前置增强 ...");
    }

    // 后置通知
    public void afterReturning(){
        System.out.println("后置增强 ...");
    }

    // 环绕通知
    // proceedingJoinPoint：正在执行的连接点对象，其实就是切点对象
    public Object round(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前。。。");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕后。。。");
        return proceed;
    }

    // 异常抛出
    public void afterThrowing(){
        System.out.println("异常抛出");
    }

    // 最终通知，无论是正常返回，还是报错
    public void after(){
        System.out.println("最终通知");
    }

}
