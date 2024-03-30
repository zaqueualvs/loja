package com.alves.lojarest.adapter.out.persistence.h2.adapters.product;

import com.alves.lojarest.adapter.out.persistence.h2.mappers.ProductPersistenceMapper;
import com.alves.lojarest.adapter.out.persistence.h2.entities.ProductEntity;
import com.alves.lojarest.adapter.out.persistence.h2.repositories.ProductRepository;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.out.product.FindProductByIdPort;
import com.alves.lojarest.common.EventPublisher;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@EventPublisher
@RequiredArgsConstructor
public class FindProductByIdPersistenceAdapter implements FindProductByIdPort {

    private final ProductRepository productRepository;
    private final ProductPersistenceMapper productPersistenceMapper;

    @Override
    public Optional<Product> findById(Long id) {
        Optional<ProductEntity> productEntityO = productRepository.findById(id);
        if (productEntityO.isEmpty()) {
            return Optional.empty();
        }
        Product product = productPersistenceMapper.toDomain(productEntityO.get());
        return Optional.of(product);
    }
}
