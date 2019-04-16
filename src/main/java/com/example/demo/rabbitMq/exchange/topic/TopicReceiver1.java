package com.example.demo.rabbitMq.exchange.topic;

import com.example.demo.dto.User;
import com.example.demo.utils.Base64Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Component
@RabbitListener(queues = TopicRabbitConstant.TOPIC_MESSAGE)
public class TopicReceiver1 {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RabbitHandler
    public void process(User user) {
        System.out.println("Receiver1  : " + user);
    }
}
