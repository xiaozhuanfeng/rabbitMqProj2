package com.example.demo.rabbitMq.exchange.topic;

import com.example.demo.dto.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = TopicRabbitConfig.MESSAGES)
public class TopicReceiver2 {
    @RabbitHandler
    public void process(User user) {
        System.out.println("Receiver2  : " + user);
    }
}
