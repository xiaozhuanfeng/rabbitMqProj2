package com.example.demo.rabbitMq.exchange.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {
    public static final String MESSAGE = "topic.message";
    public static final String MESSAGES = "topic.messages";

    @Bean
    public Queue queueMessage() {
        return new Queue(TopicRabbitConfig.MESSAGE);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(TopicRabbitConfig.MESSAGES);
    }

    @Bean
    public Queue queueUserMessage() {
        return new Queue("user.message");
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        //Queue:topic.messages  匹配路由Key:topic.#
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }

    @Bean
    Binding bindingExchangeUserMessage(Queue queueUserMessage, TopicExchange exchange) {
        //Queue:topic.messages  匹配路由Key:topic.#
        return BindingBuilder.bind(queueUserMessage).to(exchange).with("user.#");
    }
}
