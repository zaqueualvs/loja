package com.alves.lojarest.adapter.in.rest.mappers;

import com.alves.lojarest.adapter.in.rest.data.request.TagRequest;
import com.alves.lojarest.adapter.in.rest.data.response.TagResponse;
import com.alves.lojarest.adapter.in.rest.data.response.page.TagPageResponse;
import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.domain.models.page.TagPage;
import com.alves.lojarest.common.mappers.AbstractRestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TagRestMapper extends AbstractRestMapper<Tag, TagRequest, TagResponse> {

    TagPageResponse toPageResponse(TagPage tagPage);

    void copyProperties(TagRequest tagRequest, @MappingTarget Tag tag);
}
