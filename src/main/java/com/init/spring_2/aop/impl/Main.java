package com.init.spring_2.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_2/applicationContext.xml");
        ArtithmeticCalculator artithmeticCalculator = ctx.getBean(ArtithmeticCalculator.class);
        int result = artithmeticCalculator.add(3, 6);
        System.out.println(result);
        result = artithmeticCalculator.div(12, 3);
        System.out.println(result);
    }
}
