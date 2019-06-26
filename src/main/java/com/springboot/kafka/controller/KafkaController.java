package com.springboot.kafka.controller;


import com.springboot.kafka.entity.Message;
import com.springboot.kafka.producer.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import com.alibaba.fastjson.JSON;

import javax.annotation.Resource;


@Slf4j
@RestController
public class KafkaController {

    @Value("${spring.kafka.topic.Name}")
    private String TOPIC;

    @Autowired
    private KafkaProducerService producer;

    @Resource
    private KafkaTemplate kafkaTemplate;

    @RequestMapping("/sendBean")
    public void sendBean(){
        Message message = new Message("xiaomi",12,21211.23f,new Date());
        producer.sendMessage(TOPIC,JSON.toJSON(message).toString());
    }


}
