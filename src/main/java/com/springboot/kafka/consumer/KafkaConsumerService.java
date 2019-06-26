package com.springboot.kafka.consumer;


import com.alibaba.fastjson.JSON;
import com.springboot.kafka.entity.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service
public class KafkaConsumerService {



    @KafkaListener(groupId = "${spring.kafka.consumer.group-id}",topics = "${spring.kafka.topic.Name}")
    private void consumer(ConsumerRecord<String, Object> record)
    {
        System.out.println("消费者收到消息:" + record.value().toString());


    }
}
