package com.alves.lojarest.adapter.out.persistence.h2.adapters.tag;

import com.alves.lojarest.adapter.out.persistence.h2.entities.TagEntity;
import com.alves.lojarest.adapter.out.persistence.h2.mappers.CycleAvoidingMappingContext;
import com.alves.lojarest.adapter.out.persistence.h2.mappers.TagPersistenceMapper;
import com.alves.lojarest.adapter.out.persistence.h2.repositories.TagRepository;
import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.out.tag.FindTagByNamePort;
import com.alves.lojarest.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class FindTagByNamePersistenceAdapter implements FindTagByNamePort {

    private final TagPersistenceMapper tagPersistenceMapper;
    private final TagRepository tagRepository;

    @Override
    public Optional<Tag> findByName(String name) {
        Optional<TagEntity> tagEntityO = tagRepository.findByName(name);
        if (tagEntityO.isEmpty()) {
            return Optional.empty();
        }
        Tag tag = tagPersistenceMapper.toDomain(tagEntityO.get(), new CycleAvoidingMappingContext());
        return Optional.of(tag);
    }
}