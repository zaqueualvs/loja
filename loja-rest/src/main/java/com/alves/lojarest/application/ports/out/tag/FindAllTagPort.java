package com.alves.lojarest.application.ports.out.tag;

import com.alves.lojarest.application.domain.models.Tag;

import java.util.List;

public interface FindAllTagPort {
    List<Tag> findAll();
}
