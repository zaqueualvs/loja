package com.alves.lojarest.application.domain.services.tag;

import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.in.tag.FindTagByIdUseCase;
import com.alves.lojarest.common.UseCase;

@UseCase
public class FindTagByIdService implements FindTagByIdUseCase {

    @Override
    public Tag findById(Long id) {
        return null;
    }
}
