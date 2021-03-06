package com.example.demo.rabbitMq.exchange.topic;

import com.example.demo.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = TopicRabbitConstant.USER_MESSAGE)
public class TopicReceiver3 {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void process(User user) {
        System.out.println("Receiver3  : " + user);
    }
}
