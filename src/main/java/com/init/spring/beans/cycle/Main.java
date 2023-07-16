package com.init.spring.beans.cycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1/beans-cycle.xml");
        com.init.spring.beans.factory.Car car = (com.init.spring.beans.factory.Car) ctx.getBean("car");
        System.out.println(car);

        //关闭IOC容器
        ctx.close();
    }
}
