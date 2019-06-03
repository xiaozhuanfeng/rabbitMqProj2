package com.example.demo.rabbitMq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

public class MyChannelAwareMessageListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        try{
            System.out.println("====接收到消息=====");
            System.out.println(message.getMessageProperties());
            System.out.println(message.getBody().toString());

            //业务处理  do somethings....
            int i = 6/0;

            //false只确认当前一个消息收到，true确认所有consumer获得的消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }catch (Exception e){
            //拒绝消息
            if (message.getMessageProperties().getRedelivered()) {
                System.out.println("消息已重复处理失败,拒绝再次接收...");
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
            } else {
                //requeue为是否重新回到队列
                System.out.println("消息即将再次返回队列处理...");
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            }
        }
    }
}
