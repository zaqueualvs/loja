package com.alves.lojalog.application.ports.in.event;

import com.alves.lojalog.application.domain.event.ProductEvent;

public interface ProductEventeConsumerUseCase {
    void consumer(ProductEvent productEvent);
}
