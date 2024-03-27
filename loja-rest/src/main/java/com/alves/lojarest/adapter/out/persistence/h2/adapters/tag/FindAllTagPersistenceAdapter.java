package com.alves.lojarest.adapter.out.persistence.h2.adapters.tag;

import com.alves.lojarest.adapter.out.persistence.h2.mappers.CycleAvoidingMappingContext;
import com.alves.lojarest.adapter.out.persistence.h2.mappers.TagPersistenceMapper;
import com.alves.lojarest.adapter.out.persistence.h2.repositories.TagRepository;
import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.out.tag.FindAllTagPort;
import com.alves.lojarest.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class FindAllTagPersistenceAdapter implements FindAllTagPort {

    private final TagPersistenceMapper tagPersistenceMapper;
    private final TagRepository tagRepository;

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll()
                .stream()
                .map(tagEntity -> tagPersistenceMapper.toDomain(tagEntity, new CycleAvoidingMappingContext()))
                .toList();
    }
}