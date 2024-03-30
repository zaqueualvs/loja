package com.alves.lojarest.application.domain.services.tag;

import com.alves.lojarest.application.domain.event.TagEvent;
import com.alves.lojarest.application.domain.exceptions.TagNotFoundException;
import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.in.tag.FindTagByIdUseCase;
import com.alves.lojarest.application.ports.out.event.TagEventPublisherPort;
import com.alves.lojarest.application.ports.out.tag.FindTagByIdPort;
import com.alves.lojarest.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;

@UseCase
@RequiredArgsConstructor
public class FindTagByIdService implements FindTagByIdUseCase {

    private final FindTagByIdPort findTagByIdPort;
    private final TagEventPublisherPort tagEventPublisherPort;

    @Override
    @Cacheable(value = "tags_by_id", key = "#id")
    public Tag findById(Long id) {
        tagEventPublisherPort.publisherEvent(new TagEvent("FindTagByIdService.findById(Long id)"));
        return findTagByIdPort.findById(id)
                .orElseThrow(
                        () -> new TagNotFoundException(id)
                );
    }
}
