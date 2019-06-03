package com.example.demo.rabbitMq.exchange.topic;

        import org.springframework.amqp.core.Binding;
        import org.springframework.amqp.core.BindingBuilder;
        import org.springframework.amqp.core.Queue;
        import org.springframework.amqp.core.TopicExchange;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConstant {
    public static final String TOPIC_MESSAGE = "topic.message";
    public static final String TOPIC_MESSAGE_S = "topic.messages";
    public static final String USER_MESSAGE = "user.message";
    public static final String ARM_QUEUE = "arm.queue";
    public static final String BYTE_QUEUE = "byte.queue";
}
