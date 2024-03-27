
package com.alves.lojarest.adapter.out.persistence.h2.adapters.product;

import com.alves.lojarest.adapter.out.persistence.h2.entities.ProductEntity;
import com.alves.lojarest.adapter.out.persistence.h2.mappers.CycleAvoidingMappingContext;
import com.alves.lojarest.adapter.out.persistence.h2.mappers.ProductPersistenceMapper;
import com.alves.lojarest.adapter.out.persistence.h2.repositories.ProductRepository;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.out.product.SaveProductPort;
import com.alves.lojarest.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class SaveProductPersistenceAdapter implements SaveProductPort {

    private final ProductRepository productRepository;
    private final ProductPersistenceMapper productPersistenceMapper;

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productPersistenceMapper.toEntity(product);
        productEntity = productRepository.save(productEntity);
        product = productPersistenceMapper.toDomain(productEntity, new CycleAvoidingMappingContext());
        return product;
    }
}
