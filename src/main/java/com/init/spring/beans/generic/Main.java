package com.init.spring.beans.generic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1/beans-generic.xml");
        UserServcie userServcie = (UserServcie) ctx.getBean("userServcie");
        userServcie.add();
    }
}
