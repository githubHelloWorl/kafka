package com.cmd.kafka.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProducerTopic {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage( String message) {
        this.kafkaTemplate.send("test1", message);
    }
}
