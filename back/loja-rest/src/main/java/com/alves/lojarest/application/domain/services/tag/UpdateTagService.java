package com.alves.lojarest.application.domain.services.tag;

import com.alves.lojarest.application.domain.event.TagEvent;
import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.in.tag.UpdateTagUseCase;
import com.alves.lojarest.application.ports.out.event.TagEventPublisherPort;
import com.alves.lojarest.application.ports.out.tag.UpdateTagPort;
import com.alves.lojarest.common.customannotations.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UpdateTagService implements UpdateTagUseCase {

    private final UpdateTagPort updateTagPort;
    private final TagEventPublisherPort tagEventPublisherPort;

    @Override
    public Tag update(Tag tag) {
        tagEventPublisherPort.publisherEvent(new TagEvent("UpdateTagService.update(Tag tag)"));
        return updateTagPort.update(tag);
    }
}
