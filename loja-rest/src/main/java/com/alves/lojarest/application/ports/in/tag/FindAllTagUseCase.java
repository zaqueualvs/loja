package com.alves.lojarest.application.ports.in.tag;

import com.alves.lojarest.application.domain.models.Tag;

import java.util.List;

public interface FindAllTagUseCase {
    List<Tag> findAll();
}
