package com.alves.lojalog.adapters.in.eventconsumer;

import com.alves.lojalog.application.domain.event.ProductEvent;
import com.alves.lojalog.application.domain.event.TagEvent;
import com.alves.lojalog.application.ports.in.event.TagEventeConsumerUseCase;
import com.alves.lojalog.common.customannotations.EventConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@EventConsumer
@Slf4j
public class TagConsumerAdapter implements TagEventeConsumerUseCase {
    @Override
    @RabbitListener(queues = "${rabbitmq.queue.tag.name}")
    public void consumer(TagEvent tagEvent) {
        log.info(String.format("Consummer tag event message -->  %s", tagEvent));
    }

}
