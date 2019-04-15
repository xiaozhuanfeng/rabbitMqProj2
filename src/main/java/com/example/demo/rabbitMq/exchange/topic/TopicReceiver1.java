package com.example.demo.rabbitMq.exchange.topic;

import com.example.demo.dto.User;
import com.example.demo.utils.Base64Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = TopicRabbitConfig.MESSAGE)
public class TopicReceiver1 {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate rabbitTemplate;

   /* @RabbitHandler
    public void process(User user) {
        System.out.println("Receiver1  : " + user);
    }*/

    public void rec1(){
        //手动去获取消息
        logger.info("获取Queue[user.message]消息>>>>>>");
        Message mesg = rabbitTemplate.receive("user.message");

        if(null != mesg){
            byte[] body = mesg.getBody();

            //获取字符串数据
            System.out.println(new String(body));
        }

    }

    public void rec2(){
        //手动去获取消息
        logger.info("获取Queue[topic.message]消息>>>>>>");
        Message mesg = rabbitTemplate.receive("topic.message");

        if(null != mesg){
            byte[] body = mesg.getBody();
            try {
                User u = (User) Base64Utils.byteToObj(body);
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
