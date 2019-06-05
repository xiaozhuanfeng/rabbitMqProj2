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
public class TopicReceiver5 {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //@RabbitListener(queues = TopicRabbitConstant.BYTE_QUEUE, containerFactory = "rabbitListenerContainerFactory")
    @RabbitListener(queues = TopicRabbitConstant.BYTE_QUEUE)
    public void process(Message message, Channel channel) throws IOException {
        try {
            System.out.println("Receiver5  : " + new Date() + ">>>>" + Base64Utils.byteToObj(message.getBody()));
            //int i = 6/0;

        } catch (Exception e) {
            if (!message.getMessageProperties().getRedelivered()) {
                System.out.println("消息即将再次返回队列处理...");
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            } else {
                //requeue为是否重新回到队列
                System.out.println("消息已重复处理失败,拒绝再次接收...");
                //BasicReject方法第一个参数是消息的DeliveryTag，对于每个Channel来说，每个消息都会有一个DeliveryTag
                //第二个参数是是否放回queue中，requeue,如果只有一个消费者的话，true将导致无限循坏
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            }
        }
    }
}
