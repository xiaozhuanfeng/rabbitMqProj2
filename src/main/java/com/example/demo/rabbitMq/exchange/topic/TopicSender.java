package com.example.demo.rabbitMq.exchange.topic;

import com.example.demo.dto.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send1() {
        User user = new User();
        user.setUserName("Sender1.....");
        user.setMobile("1111111111");
        rabbitTemplate.convertAndSend("topicExchange",TopicRabbitConfig.MESSAGE,user);
    }

    public void send2() {
        User user = new User();
        user.setUserName("Sender2.....");
        user.setMobile("2222222");
        rabbitTemplate.convertAndSend("topicExchange",TopicRabbitConfig.MESSAGES,user);
    }

    public void send3() {
        User user = new User();
        user.setUserName("Sender3.....");
        user.setMobile("33333");
        rabbitTemplate.convertAndSend("topicExchange","user.message",user.toString());
    }
}
