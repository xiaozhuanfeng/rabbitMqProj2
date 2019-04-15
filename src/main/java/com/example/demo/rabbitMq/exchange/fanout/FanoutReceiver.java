package com.example.demo.rabbitMq.exchange.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiver {

    @RabbitHandler
    @RabbitListener(queues = "fanout.A")
    public void processA(String context) {
        System.out.println("Receiver A  : " + context);
    }

    @RabbitHandler
    @RabbitListener(queues = "fanout.B")
    public void processB(String context) {
        System.out.println("Receiver B  : " + context);
    }

    @RabbitHandler
    @RabbitListener(queues = "fanout.C")
    public void processC(String context) {
        System.out.println("Receiver C  : " + context);
    }
}
