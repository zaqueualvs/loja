package com.alves.lojarest.application.ports.out.event;

import com.alves.lojarest.application.domain.event.TagEvent;

public interface TagEventPublisherPort {

    void publisherEvent(TagEvent event);
}
