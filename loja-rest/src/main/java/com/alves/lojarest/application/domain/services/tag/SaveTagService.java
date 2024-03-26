package com.alves.lojarest.application.domain.services.tag;

import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.in.tag.SaveTagUseCase;
import com.alves.lojarest.common.UseCase;

@UseCase
public class SaveTagService implements SaveTagUseCase {
    @Override
    public Tag save(Tag tag) {
        return null;
    }
}
