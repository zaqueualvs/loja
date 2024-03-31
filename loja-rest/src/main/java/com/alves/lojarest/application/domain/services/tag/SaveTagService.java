package com.alves.lojarest.application.domain.services.tag;

import com.alves.lojarest.application.domain.event.TagEvent;
import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.in.tag.SaveTagUseCase;
import com.alves.lojarest.application.ports.out.event.TagEventPublisherPort;
import com.alves.lojarest.application.ports.out.tag.SaveTagPort;
import com.alves.lojarest.common.customannotations.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class SaveTagService implements SaveTagUseCase {

    private final SaveTagPort saveTagPort;
    private final TagEventPublisherPort tagEventPublisherPort;

    @Override
    public Tag save(Tag tag) {
        tagEventPublisherPort.publisherEvent(new TagEvent("SaveTagService.save(Tag tag)"));
        return saveTagPort.save(tag);
    }
}
