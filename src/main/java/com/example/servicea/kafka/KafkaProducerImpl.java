package com.example.servicea.kafka;

import com.example.servicea.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@EnableKafka
public class KafkaProducerImpl implements KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String msg) {
        kafkaTemplate.send(Constants.TOPIC, LocalDateTime.now().toString(), msg);
    }
}
