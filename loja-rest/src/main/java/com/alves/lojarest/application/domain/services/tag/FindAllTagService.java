package com.alves.lojarest.application.domain.services.tag;

import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.in.tag.FindAllTagUseCase;
import com.alves.lojarest.common.UseCase;

import java.util.List;

@UseCase
public class FindAllTagService implements FindAllTagUseCase {
    @Override
    public List<Tag> findAll() {
        return null;
    }
}
