package com.init.spring.beans.annotate;

import com.init.spring.beans.annotate.controller.UserController;
import com.init.spring.beans.annotate.repository.UserRepository;
import com.init.spring.beans.annotate.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_1/beans-annotate.xml");

       /* TestObject testObject= (TestObject) ctx.getBean("testObject");
        System.out.println(testObject);*/

        UserController userController = (UserController) ctx.getBean("userController");
        System.out.println(userController);
        userController.execute();

        /*UserService userService= (UserService) ctx.getBean("userService");
        System.out.println(userService);

        UserRepository userRepository= (UserRepository) ctx.getBean("userRepository");
        System.out.println(userRepository);*/
    }
}
