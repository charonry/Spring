package com.init.spring_mq;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.TextMessage;

/**
 * 整合spring的ActiveMQ生产者
 */
@Service
public class Spring_Produce {

    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_mq/applicationContext.xml");
        Spring_Produce produce = (Spring_Produce) ctx.getBean("spring_Produce");
        produce.jmsTemplate.send((session) -> {
            TextMessage textMessage = session.createTextMessage("****spring整合ActiveMQ的案例****");
            return textMessage;
        });

        System.out.println("********send task over*********");
    }
}
