package com.alves.lojarest.application.ports.out.event;

import com.alves.lojarest.application.domain.event.ProductEvent;
import com.alves.lojarest.application.domain.event.TagEvent;

public interface TagEventPublisher {

    void publisherEvent(TagEvent event);
}
