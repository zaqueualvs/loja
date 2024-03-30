package com.alves.lojarest.adapter.out.persistence.h2.adapters.product;

import com.alves.lojarest.adapter.out.persistence.h2.mappers.ProductPersistenceMapper;
import com.alves.lojarest.adapter.out.persistence.h2.repositories.ProductRepository;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.out.product.FindAllProductPort;
import com.alves.lojarest.common.EventPublisher;
import lombok.RequiredArgsConstructor;

import java.util.List;

@EventPublisher
@RequiredArgsConstructor
public class FindAllProductPersistenceAdapter implements FindAllProductPort {

    private final ProductRepository productRepository;
    private final ProductPersistenceMapper productPersistenceMapper;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productPersistenceMapper::toDomain)
                .toList();
    }
}
