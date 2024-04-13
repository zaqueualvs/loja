package com.alves.lojarest.application.ports.out.event;

import com.alves.lojarest.application.domain.event.ProductEvent;

public interface ProductEventPublisherPort {

    void publisherEvent(ProductEvent event);
}
