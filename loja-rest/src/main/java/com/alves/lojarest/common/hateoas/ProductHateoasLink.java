package com.alves.lojarest.common.hateoas;

import com.alves.lojarest.adapter.in.rest.data.response.ProductResponse;
import com.alves.lojarest.adapter.in.rest.data.response.ProductSimplifiedResponse;

public interface ProductHateoasLink {

    void addLinkToProductRespose(ProductResponse productResponse);

    void addLinkToProductSimplifiedResponse(ProductSimplifiedResponse productSimplifiedResponse);
}
