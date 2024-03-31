package com.alves.lojarest.application.domain.services.tag;

import com.alves.lojarest.application.domain.event.TagEvent;
import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.domain.models.page.TagPage;
import com.alves.lojarest.application.ports.in.tag.FindAllTagUseCase;
import com.alves.lojarest.application.ports.out.event.TagEventPublisherPort;
import com.alves.lojarest.application.ports.out.tag.FindAllTagPort;
import com.alves.lojarest.common.customannotations.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindAllTagService implements FindAllTagUseCase {

    private final FindAllTagPort findAllTagPort;
    private final TagEventPublisherPort tagEventPublisherPort;

    @Override
    public TagPage findAll(Integer page, Integer size) {
        tagEventPublisherPort.publisherEvent(new TagEvent("FindAllTagService.findAll()"));
        return findAllTagPort.findAll(page, size);
    }
}
