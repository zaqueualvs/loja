package com.alves.lojarest.application.ports.out.product;

import com.alves.lojarest.application.domain.models.Product;

public interface DeleteProductPort {

    void delete(Product product);
}
