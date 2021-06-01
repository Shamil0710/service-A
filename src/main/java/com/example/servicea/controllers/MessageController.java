package com.example.servicea.controllers;

import com.example.servicea.kafka.KafkaProducerImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
public class MessageController {

    @Autowired
    private KafkaProducerImpl kafkaProducerImpl;

    @PutMapping("/putmessage")
    public void putMessage(@RequestBody String msg) {
        log.info("Получение сообщения: " + msg + "   " + LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        kafkaProducerImpl.send(msg);
    }
}
