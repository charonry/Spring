package com.init.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQMessageProducer;
import org.apache.activemq.AsyncCallback;

import javax.jms.*;
import java.util.UUID;

/**
 * @description:
 * @author: tk
 * @create: 2019-11-04 13:45
 **/
public class JmsProduc_Async {
    public static final String ACTIVEMQ_URL = "tcp://192.168.2.122:61616";
    public static final String QUEUE_NAME = "Async";

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
        ActiveMQMessageProducer activeMQMessageProducer = (ActiveMQMessageProducer) session.createProducer(queue);
        //6.生产消息
        for (int i = 0; i < 3; i++) {
            //7.创建消息
            TextMessage textMessage = session.createTextMessage("MSG-----" + i);
            //8.给每一条消息设置id
            textMessage.setJMSMessageID(UUID.randomUUID().toString() + "--Sender" + "\t");
            String msgId = textMessage.getJMSMessageID();
            //8.通过producer将消息发送给mq，并接受回调函数
            activeMQMessageProducer.send(textMessage, new AsyncCallback() {
                @Override
                public void onSuccess() {
                    System.out.println(msgId + "has been ok send");
                }

                @Override
                public void onException(JMSException e) {
                    System.out.println(msgId + "fail to send");
                }
            });
        }
        //9.关闭资源
        activeMQMessageProducer.close();
        session.close();
        connection.close();
        System.out.println("-------消息全部发送完毕-----");
    }
}
