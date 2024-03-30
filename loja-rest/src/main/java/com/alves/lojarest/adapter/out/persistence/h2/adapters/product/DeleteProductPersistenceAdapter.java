package com.alves.lojarest.adapter.out.persistence.h2.adapters.product;

import com.alves.lojarest.adapter.out.persistence.h2.mappers.ProductPersistenceMapper;
import com.alves.lojarest.adapter.out.persistence.h2.entities.ProductEntity;
import com.alves.lojarest.adapter.out.persistence.h2.repositories.ProductRepository;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.out.product.DeleteProductPort;
import lombok.RequiredArgsConstructor;
import com.alves.lojarest.common.EventPublisher;

@EventPublisher
@RequiredArgsConstructor
public class DeleteProductPersistenceAdapter implements DeleteProductPort {

    private final ProductPersistenceMapper productPersistenceMapper;
    private final ProductRepository productRepository;

    @Override
    public void delete(Product product) {
        ProductEntity productEntity = productPersistenceMapper.toEntity(product);
        productRepository.delete(productEntity);
    }
}
