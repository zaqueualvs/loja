package com.alves.lojarest.adapter.out.persistence.h2.mappers;

import com.alves.lojarest.adapter.out.persistence.h2.entities.ProductEntity;
import com.alves.lojarest.adapter.out.persistence.h2.entities.TagEntity;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.domain.models.Tag;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = TagPersistenceMapper.class)
public interface ProductPersistenceMapper {

    Product toDomain(ProductEntity productEntity, @Context CycleAvoidingMappingContext context);

    ProductEntity toEntity(Product product);
}
