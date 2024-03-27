package com.alves.lojarest.adapter.out.persistence.h2.adapters.product;

import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.out.product.SaveProductPort;
import com.alves.lojarest.application.ports.out.product.UpdateProductPort;
import com.alves.lojarest.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class UpdateProductPersistenceAdapter implements UpdateProductPort {

    private final SaveProductPort saveProductPort;

    @Override
    public Product update(Product product) {
        return saveProductPort.save(product);
    }
}
