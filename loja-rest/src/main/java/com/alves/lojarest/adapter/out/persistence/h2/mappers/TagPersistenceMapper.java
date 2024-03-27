package com.alves.lojarest.adapter.out.persistence.h2.mappers;

import com.alves.lojarest.adapter.out.persistence.h2.entities.TagEntity;
import com.alves.lojarest.application.domain.models.Tag;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagPersistenceMapper {

    Tag toDomain(TagEntity tagEntity, @Context CycleAvoidingMappingContext context);

    TagEntity toEntity(Tag tag);
}
