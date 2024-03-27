package com.alves.lojarest.adapter.out.persistence.h2.adapters.product;

import com.alves.lojarest.adapter.out.persistence.h2.entities.ProductEntity;
import com.alves.lojarest.adapter.out.persistence.h2.mappers.CycleAvoidingMappingContext;
import com.alves.lojarest.adapter.out.persistence.h2.mappers.ProductPersistenceMapper;
import com.alves.lojarest.adapter.out.persistence.h2.repositories.ProductRepository;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.out.product.FindProductByNamePort;
import com.alves.lojarest.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class FindProductByNamePersistenceAdapter implements FindProductByNamePort {

    private final ProductRepository productRepository;
    private final ProductPersistenceMapper productPersistenceMapper;

    @Override
    public Optional<Product> findByName(String name) {
        Optional<ProductEntity> productEntityO = productRepository.findByName(name);
        if (productEntityO.isEmpty()) {
            return Optional.empty();
        }
        Product product = productPersistenceMapper.toDomain(productEntityO.get(), new CycleAvoidingMappingContext());
        return Optional.of(product);
    }
}
