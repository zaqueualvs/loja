package com.alves.lojarest.adapter.in.rest.mappers;

import com.alves.lojarest.adapter.in.rest.data.request.TagRequest;
import com.alves.lojarest.adapter.in.rest.data.response.TagResponse;
import com.alves.lojarest.application.domain.models.Tag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagRestMapper {
    Tag toDomain(TagRequest tagRequest);

    TagResponse toResponse(Tag tag);
}
