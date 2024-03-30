package com.alves.lojarest.adapter.out.persistence.h2.mappers;

import com.alves.lojarest.adapter.out.persistence.h2.entities.ProductEntity;
import com.alves.lojarest.adapter.out.persistence.h2.entities.TagEntity;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.common.mappers.AbstractPersistenceMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TagPersistenceMapper extends AbstractPersistenceMapper<Tag, TagEntity> {

    @Mapping(target = "tags", ignore = true)
    Product productEntityToProduct(ProductEntity productEntity);

    @Mapping(target = "tags", ignore = true)
    ProductEntity tagToTagEntity(Product product);
}
