package com.kafka.kafkademo.kafka;

import com.kafka.kafkademo.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
private static final Logger log= LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "firstTopic",groupId = "myConsGroup")
    public void consume(String msg){
        log.info(String.format("Message Recevied -> %s",msg));
    }

    @KafkaListener(topics = "JsonTopic",groupId = "myConsGroup")
    public void JsonConsume(User user){
        log.info(user.toString());
    }
}
