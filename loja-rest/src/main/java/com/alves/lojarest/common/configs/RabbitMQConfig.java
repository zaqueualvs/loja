package com.alves.lojarest.common.configs;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.product.name}")
    private String queueProduct;
    @Value("${rabbitmq.queue.tag.name}")
    private String queueTag;
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routingKey.product.name}")
    private String routingKeyProduct;
    @Value("${rabbitmq.routingKey.tag.name}")
    private String routingKeyTag;

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Queue queueProduct() {
        return new Queue(queueProduct);
    }
    @Bean
    public Queue queueTag() {
        return new Queue(queueTag);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding binding_product() {
        return BindingBuilder.bind(queueProduct())
                .to(exchange())
                .with(routingKeyProduct);
    }

    @Bean
    public Binding binding_tag() {
        return BindingBuilder.bind(queueTag())
                .to(exchange())
                .with(routingKeyTag);
    }

}
