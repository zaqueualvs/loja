package com.alves.lojarest.application.domain.services.tag;

import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.in.tag.UpdateTagUseCase;
import com.alves.lojarest.common.UseCase;

@UseCase
public class UpdateTagService implements UpdateTagUseCase {
    @Override
    public Tag update(Tag tag) {
        return null;
    }
}
