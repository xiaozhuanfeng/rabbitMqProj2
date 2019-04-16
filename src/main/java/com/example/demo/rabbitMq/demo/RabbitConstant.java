package com.example.demo.rabbitMq.demo;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConstant {
    public static final String MESG_QUEUE_KEY = "mesgQue";
}
