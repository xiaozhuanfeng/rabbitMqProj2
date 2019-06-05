package com.example.demo.rabbitMq.exchange.topic;

import com.example.demo.utils.Base64Utils;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Component
public class TopicReceiver6 {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitListener(queues = TopicRabbitConstant.DELAY_QUEUE)
    public void process(Message message, Channel channel) throws IOException {
        try {
            System.out.println("Receiver6  : " + new Date() + ">>>>" + Base64Utils.byteToObj(message.getBody()));

        } catch (Exception e) {
            logger.error("接收失败",e);
        }
    }
}
