package com.alves.lojarest.application.ports.in.product;

import com.alves.lojarest.application.domain.models.Product;

import java.util.List;

public interface FindAllProductUseCase {
    List<Product> findAll();
}
