package com.init.spring.beans.autowire;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1/beans-annotation.xml");
        Person person = (Person) ctx.getBean("person");
        //System.out.println(person);
        Person person2 = (Person) ctx.getBean("person2");
        //System.out.println(person2);
        Person person3 = (Person) ctx.getBean("person3");
        //System.out.println(person3);
    }
}
