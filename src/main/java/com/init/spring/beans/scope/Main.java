package com.init.spring.beans.scope;


import com.init.spring.beans.autowire.Address;
import com.init.spring.beans.autowire.Car;
import com.init.spring.beans.autowire.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1/beans-scope.xml");
        Car car = (Car) ctx.getBean("car");
        Car car2 = (Car) ctx.getBean("car");
        System.out.println(car == car2);
    }
}
