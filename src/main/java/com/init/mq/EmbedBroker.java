package com.init.mq;

import org.apache.activemq.broker.BrokerService;

/**
 * Broker的案列
 */
public class EmbedBroker {
    public static void main(String[] args) throws Exception {
        //ActiveMQ也支持vm中通信基于嵌入式的broker
        BrokerService brokerService = new BrokerService();
        brokerService.setUseJmx(true);
        brokerService.addConnector("tcp://localhost:61617");
        brokerService.start();
    }
}
