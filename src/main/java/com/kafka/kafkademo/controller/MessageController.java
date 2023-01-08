package com.kafka.kafkademo.controller;

import com.kafka.kafkademo.kafka.KafkaProducer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/kafka")
public class MessageController {
    private KafkaProducer kafkaProducer;

//    public MessageController(KafkaProducer kafkaProducer) {
//        this.kafkaProducer = kafkaProducer;
//    }

    //http:localhost/api/kafka/publish?message=hello
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok(String.format("Message sent to the topic: %s",message));
    }
}
