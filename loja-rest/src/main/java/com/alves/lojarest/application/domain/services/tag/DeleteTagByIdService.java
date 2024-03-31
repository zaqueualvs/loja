package com.alves.lojarest.application.domain.services.tag;

import com.alves.lojarest.application.domain.event.TagEvent;
import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.in.tag.DeleteTagByIdUseCase;
import com.alves.lojarest.application.ports.in.tag.FindTagByIdUseCase;
import com.alves.lojarest.application.ports.out.event.TagEventPublisherPort;
import com.alves.lojarest.application.ports.out.tag.DeleteTagPort;
import com.alves.lojarest.application.ports.out.tag.FindTagByIdPort;
import com.alves.lojarest.common.customannotations.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class DeleteTagByIdService implements DeleteTagByIdUseCase {
    private final DeleteTagPort deleteTagPort;
    private final FindTagByIdUseCase findTagByIdUseCase;
    private final TagEventPublisherPort tagEventPublisherPort;

    @Override
    public void deleteById(Long id) {
        tagEventPublisherPort.publisherEvent(new TagEvent("DeleteTagByIdService.deleteById(Long id)"));
        Tag tag = findTagByIdUseCase.findById(id);
        deleteTagPort.delete(tag);
    }
}
