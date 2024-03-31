package com.alves.lojarest.adapter.in.rest.mappers;

import com.alves.lojarest.adapter.in.rest.data.request.ProductRequest;
import com.alves.lojarest.adapter.in.rest.data.response.ProductResponse;
import com.alves.lojarest.adapter.in.rest.data.response.page.ProductPageResponse;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.domain.models.page.ProductPage;
import com.alves.lojarest.common.mappers.AbstractRestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductRestMapper extends AbstractRestMapper<Product, ProductRequest, ProductResponse> {

    ProductPageResponse toPageResponse(ProductPage productPage);

    void copyProperties(ProductRequest productRequest, @MappingTarget Product product);
}
