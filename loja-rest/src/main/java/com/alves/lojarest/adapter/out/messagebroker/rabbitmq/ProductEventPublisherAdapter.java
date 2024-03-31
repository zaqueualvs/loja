package com.alves.lojarest.adapter.out.messagebroker.rabbitmq;

import com.alves.lojarest.application.domain.event.ProductEvent;
import com.alves.lojarest.application.ports.out.event.ProductEventPublisherPort;
import com.alves.lojarest.common.customannotations.EventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;

@EventPublisher
@RequiredArgsConstructor
@Slf4j
public class ProductEventPublisherAdapter implements ProductEventPublisherPort {

    private final RabbitTemplate rabbitTemplate;
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routingKey.product.name}")
    private String routingKey;

    @Override
    public void publisherEvent(ProductEvent productEvent) {
        rabbitTemplate.convertAndSend(exchange, routingKey, productEvent);
    }
}
