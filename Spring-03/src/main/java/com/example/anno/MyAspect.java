package com.example.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component("myAspect")
@Aspect  // 标注当前类是一个切面类
public class MyAspect {

    // 注解的方式，切入点表达式抽取，随便作用在某一个方法的上面
    @Pointcut("execution(* com.example.anno.*.*(..))")
    public void pointcut(){}

    // 使用注解的方式，配置前置通知
    @Before("execution(* com.example.anno.*.*(..))")
    public void before(){
        System.out.println("前置增强 ...");
    }

    // 后置通知
    @AfterReturning("pointcut()")
    public void afterReturning(){
        System.out.println("后置增强 ...");
    }

    // 环绕通知，proceedingJoinPoint：正在执行的连接点对象，其实就是切点对象
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

    // 最终通知，无论是正常返回，还是报错，都会执行该通知
    public void after(){
        System.out.println("最终通知");
    }

}
