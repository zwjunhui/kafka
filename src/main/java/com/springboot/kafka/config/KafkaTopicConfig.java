package com.springboot.kafka.config;


import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;

    @Value("${spring.kafka.topic.Name}")
    private String topicName;

    @Value("${spring.kafka.topic.numPartitions}")
    private int numPartitions;

    @Value("${spring.kafka.topic.replicationFactor}")
    private int replicationFactor;

   @Bean
    public KafkaAdmin kafkaAdmin(){
        Map<String,Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServer);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic mytopic(){
        return new NewTopic(topicName,numPartitions,(short)replicationFactor);
    }


}
