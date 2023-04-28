package com.example.demo.services;

import jakarta.jms.Destination;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
@Service
public class JmsDispatcherService implements IBookMessagingService{
    private JmsTemplate jms;

    @Value("${jms.queue}")
    private String jmsQueue;

    @Autowired
    public JmsDispatcherService(JmsTemplate jms)
    {
        this.jms = jms;
    }

    public void sendMessage(String message)
    {
        jms.convertAndSend(jmsQueue,message);
    }

    @Bean
    public Destination bookQueue()
    {
        return new ActiveMQQueue("book.queue");
    }
}
