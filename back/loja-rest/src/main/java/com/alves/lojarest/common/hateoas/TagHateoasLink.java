package com.alves.lojarest.common.hateoas;

import com.alves.lojarest.adapter.in.rest.data.response.TagResponse;
import com.alves.lojarest.adapter.in.rest.data.response.TagSimplifiedResponse;

public interface TagHateoasLink {

    void addLinkToTagRespose(TagResponse tagResponse);

    void addLinkToTagSimplifiedResponse(TagSimplifiedResponse tagSimplifiedResponse);

}