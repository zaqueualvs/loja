package com.alves.lojarest.application.ports.out.product;

import com.alves.lojarest.application.domain.models.Product;

public interface UpdateProductPort {
    Product update(Product product);
}
