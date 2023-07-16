package com.init.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProduce {
    //broker的应用
    //public static final String ACTIVEMQ_URL="tcp://localhost:61617";
    public static final String ACTIVEMQ_URL = "tcp://192.168.2.122:61616";
    //NIO传输（auto+nio）
    //public static final String ACTIVEMQ_URL="tcp://192.168.2.122:61608";
    public static final String QUEUE_NAME = "nioAuto";

    public static void main(String[] args) throws JMSException {
        //1.创建连接工厂，按照给定的URL地址，采用默认用户名和密码
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //异步发送允许消息丢失
        activeMQConnectionFactory.setUseAsyncSend(true);
        //2/通过连接工厂，获取连接connection并启动访问
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        //3.创建会话session
        //第一个参数表示事务，第二表示签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4.创建目的地，具体四队列还是主题
        Queue queue = session.createQueue(QUEUE_NAME);
        //5.创建消息生产者
        MessageProducer producer = session.createProducer(queue);
        //6.生产消息
        for (int i = 0; i < 3; i++) {
            //7.创建消息
            TextMessage textMessage = session.createTextMessage("MSG-----" + i);
            textMessage.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
            //只创建了一个消息属性
            /*if(i==2){
                textMessage.setStringProperty("c02","vip");
            }*/
            //以mapmessage消息体发送
          /*  MapMessage mapMessage = session.createMapMessage();
            mapMessage.setString("map",String.valueOf(i+10));*/

            //8.通过producer将消息发送给mq
            producer.send(textMessage);
            //producer.send(mapMessage);
        }
        //9.关闭资源
        producer.close();
        session.close();
        connection.close();
        System.out.println("-------消息全部发送完毕-----");
    }
}
