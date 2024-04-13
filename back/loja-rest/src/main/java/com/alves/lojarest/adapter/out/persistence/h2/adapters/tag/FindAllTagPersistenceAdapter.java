package com.alves.lojarest.adapter.out.persistence.h2.adapters.tag;

import com.alves.lojarest.adapter.out.persistence.h2.entities.TagEntity;
import com.alves.lojarest.adapter.out.persistence.h2.mappers.TagPersistenceMapper;
import com.alves.lojarest.adapter.out.persistence.h2.repositories.TagRepository;
import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.domain.models.page.TagPage;
import com.alves.lojarest.application.ports.out.tag.FindAllTagPort;
import com.alves.lojarest.common.customannotations.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@EventPublisher
@RequiredArgsConstructor
public class FindAllTagPersistenceAdapter implements FindAllTagPort {

    private final TagPersistenceMapper tagPersistenceMapper;
    private final TagRepository tagRepository;

    @Override
    public TagPage findAll(Integer page, Integer size) {
        Page<TagEntity> tagEntityPage = tagRepository.findAll(PageRequest.of(page, size));
        List<Tag> tags = tagEntityPage
                .stream()
                .map(tagPersistenceMapper::toDomain)
                .toList();
        return new TagPage(tags, tagEntityPage.getTotalElements(), tagEntityPage.getTotalPages());
    }
}
