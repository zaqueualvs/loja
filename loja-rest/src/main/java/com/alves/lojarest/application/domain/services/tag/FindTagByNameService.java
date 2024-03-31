package com.alves.lojarest.application.domain.services.tag;

import com.alves.lojarest.application.domain.event.TagEvent;
import com.alves.lojarest.application.domain.exceptions.TagNotFoundException;
import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.in.tag.FindTagByNameUseCase;
import com.alves.lojarest.application.ports.out.event.TagEventPublisherPort;
import com.alves.lojarest.application.ports.out.tag.FindTagByNamePort;
import com.alves.lojarest.common.customannotations.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class FindTagByNameService implements FindTagByNameUseCase {

    private final FindTagByNamePort findTagByNamePort;
    private final TagEventPublisherPort tagEventPublisherPort;

    @Override
    public Tag findByName(String name) {
        tagEventPublisherPort.publisherEvent(new TagEvent("FindTagByNameService.findByName(String name)"));
        return findTagByNamePort.findByName(name)
                .orElseThrow(
                        () -> new TagNotFoundException(
                                String.format("There is no tag registration with name %s.", name))
                );

    }
}
