package com.alves.lojarest.adapter.out.persistence.h2.adapters.tag;

import com.alves.lojarest.adapter.out.persistence.h2.entities.TagEntity;
import com.alves.lojarest.adapter.out.persistence.h2.mappers.TagPersistenceMapper;
import com.alves.lojarest.adapter.out.persistence.h2.repositories.TagRepository;
import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.out.tag.SaveTagPort;
import com.alves.lojarest.common.EventPublisher;
import lombok.RequiredArgsConstructor;

@EventPublisher
@RequiredArgsConstructor
public class SaveTagPersistenceAdapter implements SaveTagPort {
    private final TagPersistenceMapper tagPersistenceMapper;
    private final TagRepository tagRepository;

    @Override
    public Tag save(Tag tag) {
        TagEntity tagEntity = tagPersistenceMapper.toEntity(tag);
        tagEntity = tagRepository.save(tagEntity);
        tag = tagPersistenceMapper.toDomain(tagEntity);
        return tag;
    }
}
