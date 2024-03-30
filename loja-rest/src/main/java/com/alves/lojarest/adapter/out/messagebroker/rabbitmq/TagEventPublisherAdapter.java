package com.alves.lojarest.adapter.out.messagebroker.rabbitmq;

import com.alves.lojarest.application.domain.event.TagEvent;
import com.alves.lojarest.application.ports.out.event.TagEventPublisherPort;
import com.alves.lojarest.common.EventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;

@EventPublisher
@RequiredArgsConstructor
@Slf4j
public class TagEventPublisherAdapter implements TagEventPublisherPort {

    private final RabbitTemplate rabbitTemplate;
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routingKey.tag.name}")
    private String routingKey;

    @Override
    public void publisherEvent(TagEvent tagEvent) {
        rabbitTemplate.convertAndSend(exchange, routingKey, tagEvent);
    }
}
