package com.springboot.kafka.producer;


import com.springboot.kafka.constant.KafkaMesConstant;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;


@Service
public class KafkaProducerService {


    private Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.topic.Name}")
    private String topic;


    @Async("logThred")
    public void sendMessage(String topic, String object) {


        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(new ProducerRecord<>(topic,object));
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                logger.info("发送消息失败:" + throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> sendResult) {
                System.out.println("发送结果:" + sendResult.toString());
            }
        });


    }
}
