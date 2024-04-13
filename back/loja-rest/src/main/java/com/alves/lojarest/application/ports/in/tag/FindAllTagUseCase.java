package com.alves.lojarest.application.ports.in.tag;

import com.alves.lojarest.application.domain.models.page.TagPage;

public interface FindAllTagUseCase {
    TagPage findAll(Integer page, Integer size);
}
