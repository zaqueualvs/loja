package com.alves.lojarest.adapter.in.rest.mappers;

import com.alves.lojarest.adapter.in.rest.data.request.ProductRequest;
import com.alves.lojarest.adapter.in.rest.data.response.ProductResponse;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.common.mappers.AbstractRestMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductRestMapper extends AbstractRestMapper<Product, ProductRequest, ProductResponse> {

}
