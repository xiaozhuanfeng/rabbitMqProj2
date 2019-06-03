package com.example.demo.rabbitMq;

import com.example.demo.utils.Base64Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RabbitMqRevTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Test
    public void topicRev1(){
        rev1();
    }

    public void rev1(){
        //手动去获取消息
        logger.info("获取Queue[arm.gun]消息>>>");
        Message mesg = rabbitTemplate.receive("arm.queue");
        System.out.println(mesg);

        if(null != mesg){
            byte[] body = mesg.getBody();
            try {
                List u = (List) Base64Utils.byteToObj(body);
                //获取字符串数据
                System.out.println(u);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


}
