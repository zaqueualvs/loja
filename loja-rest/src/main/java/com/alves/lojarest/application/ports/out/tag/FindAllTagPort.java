package com.alves.lojarest.application.ports.out.tag;

import com.alves.lojarest.application.domain.models.page.TagPage;

public interface FindAllTagPort {
    TagPage findAll(Integer page, Integer size);
}
