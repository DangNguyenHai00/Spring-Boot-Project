package com.example.demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.sound.midi.Receiver;

@Service
public class JmsReceiverService {
    Logger log = LoggerFactory.getLogger(JmsReceiverService.class);

    @JmsListener(destination = "${jms.queue}")
    public void ReceiveMessage(String message)
    {
        log.info("Received message: "+message);
    }
}
