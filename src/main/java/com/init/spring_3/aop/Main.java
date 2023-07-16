package com.init.spring_3.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_3/applicationContext.xml");
        ArtithmeticCalculator artithmeticCalculator = (ArtithmeticCalculator) ctx.getBean("artithmeticCalculator");
        System.out.println(artithmeticCalculator.getClass().getName());
        int result = artithmeticCalculator.add(2, 4);
        System.out.println(result);
        result = artithmeticCalculator.div(100, 25);
        System.out.println(result);
    }
}
