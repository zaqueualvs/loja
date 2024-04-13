package com.alves.lojarest.application.ports.out.product;

import com.alves.lojarest.application.domain.models.Product;

import java.util.Optional;

public interface FindProductByIdPort {

    Optional<Product> findById(Long id);
}
