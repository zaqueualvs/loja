package com.alves.lojarest.adapter.out.persistence.h2.adapters.tag;

import com.alves.lojarest.adapter.out.persistence.h2.entities.TagEntity;
import com.alves.lojarest.adapter.out.persistence.h2.mappers.TagPersistenceMapper;
import com.alves.lojarest.adapter.out.persistence.h2.repositories.TagRepository;
import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.out.tag.DeleteTagPort;
import com.alves.lojarest.common.customannotations.EventPublisher;
import lombok.RequiredArgsConstructor;

@EventPublisher
@RequiredArgsConstructor
public class DeleteTagPersistenceAdapter implements DeleteTagPort {

    private final TagPersistenceMapper tagPersistenceMapper;
    private final TagRepository tagRepository;
    @Override
    public void delete(Tag tag) {
        TagEntity tagEntity = tagPersistenceMapper.toEntity(tag);
        tagRepository.delete(tagEntity);
    }
}
