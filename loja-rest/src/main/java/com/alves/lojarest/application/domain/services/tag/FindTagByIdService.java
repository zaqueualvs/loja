package com.alves.lojarest.application.domain.services.tag;

import com.alves.lojarest.application.domain.exceptions.TagNotFoundException;
import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.in.tag.FindTagByIdUseCase;
import com.alves.lojarest.application.ports.out.tag.FindTagByIdPort;
import com.alves.lojarest.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class FindTagByIdService implements FindTagByIdUseCase {

    private final FindTagByIdPort findTagByIdPort;

    @Override
    public Tag findById(Long id) {
        return findTagByIdPort.findById(id)
                .orElseThrow(
                        () -> new TagNotFoundException(id)
                );
    }
}
