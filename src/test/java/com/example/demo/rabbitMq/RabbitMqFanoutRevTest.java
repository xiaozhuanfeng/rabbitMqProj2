package com.example.demo.rabbitMq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqFanoutRevTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Test
    public void send() throws Exception {
        Message mesg = rabbitTemplate.receive("fanout.A");
        System.out.println("fanout.A  >"+mesg);

        mesg = rabbitTemplate.receive("fanout.B");
        System.out.println("fanout.B  >"+mesg);

        mesg = rabbitTemplate.receive("fanout.C");
        System.out.println("fanout.B  >"+mesg);
    }
}
