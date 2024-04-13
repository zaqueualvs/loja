package com.alves.lojarest.application.ports.in.tag;

import com.alves.lojarest.application.domain.models.Tag;

public interface UpdateTagUseCase {
    Tag update(Tag tag);
}
