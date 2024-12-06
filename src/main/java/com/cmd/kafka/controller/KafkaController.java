package com.cmd.kafka.controller;

import com.cmd.kafka.mq.ProducerTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    private ProducerTopic producerTopic;

    @GetMapping("/product")
    public String product(@RequestParam("topic") String topic){
        producerTopic.sendMessage(topic);
        return "success";
    }
}
