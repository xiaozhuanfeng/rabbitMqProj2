package com.example.demo.rabbitMq;

import com.example.demo.rabbitMq.demo.HelloSender;
import com.example.demo.rabbitMq.demo.HelloSender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {
    @Autowired
    private HelloSender helloSender;

    @Autowired
    private HelloSender2 helloSender2;

    @Test
    public void hello() throws Exception {
        helloSender.send();
    }

    @Test
    public void oneSenderToManyRec() throws Exception {
        for (int i=0;i<100;i++){
            helloSender2.send(i);
        }
    }
}
