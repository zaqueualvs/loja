package com.alves.lojarest.application.ports.out.tag;

import com.alves.lojarest.application.domain.models.Tag;

import java.util.Optional;

public interface FindTagByIdPort {

    Optional<Tag> findById(Long id);
}
