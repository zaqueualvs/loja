package com.alves.lojalog.adapters.in.eventconsumer;

import com.alves.lojalog.application.ports.in.event.ProductEventeConsumerUseCase;
import com.alves.lojalog.common.customannotations.EventConsumer;
import com.alves.lojalog.application.domain.event.ProductEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@EventConsumer
@Slf4j
public class ProductConsumerAdapter implements ProductEventeConsumerUseCase {
    @Override
    @RabbitListener(queues = "${rabbitmq.queue.product.name}")
    public void consumer(ProductEvent productEvent) {
        log.info(String.format("Consummer product event message -> %s", productEvent));
    }

}
