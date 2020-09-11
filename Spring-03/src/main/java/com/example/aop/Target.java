package com.example.aop;

public class Target implements TargetInterface {

    @Override
    // PointCut 切点
    public void save() {
        System.out.println("save running...");
    }
}
