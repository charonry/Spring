package com.init.spring.beans.relation;


import com.init.spring.beans.autowire.Address;
import com.init.spring.beans.autowire.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1/beans-relation.xml");
       /* Address address=(Address) ctx.getBean("address");
        System.out.println(address);*/
        Address address2 = (Address) ctx.getBean("address2");
        System.out.println(address2);
        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
    }
}
