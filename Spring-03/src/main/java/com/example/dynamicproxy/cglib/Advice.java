package com.example.dynamicproxy.cglib;

public class Advice {

    public void before(){
        System.out.println("前置增强");
    }

    public void after(){
        System.out.println("后置增强");
    }
}
