package com.alves.lojarest.application.ports.in.product;

import com.alves.lojarest.application.domain.models.Product;

public interface UpdateProductUseCase {
    Product update(Product product);
}
