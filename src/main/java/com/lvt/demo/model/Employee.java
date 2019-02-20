package com.lvt.demo.model;

import com.lvt.demo.aop.Loggable;
import org.springframework.stereotype.Component;

public class Employee {
    public void method1() {
        System.out.println("Method 1 call >>>>>>>>>>>>>>>");
    }

    public void method2() {
        System.out.println("Method 2 call >>>>>>>>>>>>>>>");
    }

    public void method3() {
        System.out.println("Method 3 call >>>>>>>>>>>>>>>");
    }

    public void method4() {
        System.out.println("Method 4 call >>>>>>>>>>>>>>>");
    }
}
