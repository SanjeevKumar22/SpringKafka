package com.kafka.kafkademo.kafka;

import com.kafka.kafkademo.payload.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class JsonKafkaProducer {
 private KafkaTemplate<String, User> kafkaTemplate;

 public void sendMessage(User data){
     log.info(String.format("message sent succesfully : %s",data.toString()));
     Message<User> message= MessageBuilder
             .withPayload(data)
             .setHeader(KafkaHeaders.TOPIC,"JsonTopic")
             .build();
     kafkaTemplate.send(message);
    }
}
