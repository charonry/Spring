package com.init.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProduce_Topic {
    public static final String ACTIVEMQ_URL = "tcp://192.168.2.122:61616";
    public static final String TOPIC_NAME = "topic01";

    public static void main(String[] args) throws JMSException {
        //1.创建连接工厂，按照给定的URL地址，采用默认用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //2/通过连接工厂，获取连接connection并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();

        //3.创建会话session
        //第一个参数表示事务，第二表示签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4.创建目的地，具体四队列还是主题
        Topic topic = session.createTopic(TOPIC_NAME);
        //5.创建消息生产者
        MessageProducer producer = session.createProducer(topic);

        connection.start();//移动至此，是开启持久化
        //6.生产消息
        for (int i = 0; i < 3; i++) {
            //7.创建消息
            TextMessage textMessage = session.createTextMessage("MSG-----" + i);

            //8.通过producer将消息发送给mq
            producer.send(textMessage);

        }
        //9.关闭资源
        producer.close();
        session.close();
        connection.close();
        System.out.println("-------TOPIC_NAME消息全部发送完毕-----");
    }
}
