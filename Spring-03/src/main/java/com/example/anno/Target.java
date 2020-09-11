package com.example.anno;


import org.springframework.stereotype.Component;

@Component("target")
public class Target implements TargetInterface {

    @Override
    // PointCut 切入点
    public void save() {
        System.out.println("save running...");
    }
}
