package com.init.spring.beans.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1/applicationContext.xml");
        HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
        // System.out.println(helloWorld);
        Per person = (Per) ctx.getBean("person");
        // System.out.println(person);
        /* Per person2=(Per) ctx.getBean("person2");*/
        // System.out.println(per);
        Person person3 = (Person) ctx.getBean("person3");
        //System.out.println(person3);
        NewPerson newPerson = (NewPerson) ctx.getBean("newPerson");
        //System.out.println(newPerson);
        DataSource dataSource = ctx.getBean(DataSource.class);
        //System.out.println(dataSource.getProperties());
        Person person4 = (Person) ctx.getBean("person4");
        //System.out.println(person4);
        Person person5 = (Person) ctx.getBean("person5");
        //System.out.println(person5);

    }
}
