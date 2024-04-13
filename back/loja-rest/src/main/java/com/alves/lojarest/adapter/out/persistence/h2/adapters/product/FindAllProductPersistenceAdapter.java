package com.alves.lojarest.adapter.out.persistence.h2.adapters.product;

import com.alves.lojarest.adapter.out.persistence.h2.entities.ProductEntity;
import com.alves.lojarest.adapter.out.persistence.h2.mappers.ProductPersistenceMapper;
import com.alves.lojarest.adapter.out.persistence.h2.repositories.ProductRepository;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.domain.models.page.ProductPage;
import com.alves.lojarest.application.ports.out.product.FindAllProductPort;
import com.alves.lojarest.common.customannotations.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@EventPublisher
@RequiredArgsConstructor
public class FindAllProductPersistenceAdapter implements FindAllProductPort {

    private final ProductRepository productRepository;
    private final ProductPersistenceMapper productPersistenceMapper;

    @Override
    public ProductPage findAll(Integer page, Integer size) {
        Page<ProductEntity> productEntityPage = productRepository.findAll(PageRequest.of(page, size));
        List<Product> products = productEntityPage
                .stream()
                .map(productPersistenceMapper::toDomain)
                .toList();
        return new ProductPage(products, productEntityPage.getTotalElements(), productEntityPage.getTotalPages());
    }
}
