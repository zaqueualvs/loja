package com.alves.lojarest.application.ports.out.tag;

import com.alves.lojarest.application.domain.models.Tag;

public interface SaveTagPort {
    Tag save(Tag tag);
}
