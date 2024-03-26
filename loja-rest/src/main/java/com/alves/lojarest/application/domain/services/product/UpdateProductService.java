package com.alves.lojarest.application.domain.services.product;

import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.in.product.UpdateProductUseCase;
import com.alves.lojarest.common.UseCase;

@UseCase
public class UpdateProductService implements UpdateProductUseCase {
    @Override
    public Product update(Product product) {
        return null;
    }
}
