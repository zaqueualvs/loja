package com.alves.lojarest.application.domain.services.tag;

import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.in.tag.FindTagByNameUseCase;
import com.alves.lojarest.common.UseCase;

@UseCase
public class FindTagByNameService implements FindTagByNameUseCase {

    @Override
    public Tag findByName(String name) {
        return null;
    }
}
