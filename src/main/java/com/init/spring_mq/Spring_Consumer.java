package com.init.spring_mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;


/**
 * 整合spring的ActiveMQ消费者
 */
@Service
public class Spring_Consumer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring_mq/applicationContext.xml");
        Spring_Consumer consumer = (Spring_Consumer) ctx.getBean("spring_Consumer");
        String value = (String) consumer.jmsTemplate.receiveAndConvert();
        System.out.println("消费者收到的消息是：" + value);
    }
}
