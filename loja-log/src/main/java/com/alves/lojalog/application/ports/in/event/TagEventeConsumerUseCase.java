package com.alves.lojalog.application.ports.in.event;

import com.alves.lojalog.application.domain.event.ProductEvent;
import com.alves.lojalog.application.domain.event.TagEvent;

public interface TagEventeConsumerUseCase {
    void consumer(TagEvent tagEvent);
}
