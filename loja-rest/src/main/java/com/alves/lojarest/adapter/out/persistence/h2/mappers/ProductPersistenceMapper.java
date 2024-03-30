package com.alves.lojarest.adapter.out.persistence.h2.mappers;


import com.alves.lojarest.adapter.out.persistence.h2.entities.ProductEntity;
import com.alves.lojarest.adapter.out.persistence.h2.entities.TagEntity;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.common.mappers.AbstractPersistenceMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductPersistenceMapper extends AbstractPersistenceMapper<Product, ProductEntity> {

    @Mapping(target = "products", ignore = true)
    Tag tagEntityToTag(TagEntity tagEntity);

    @Mapping(target = "products", ignore = true)
    TagEntity tagToTagEntity(Tag tag);
}
