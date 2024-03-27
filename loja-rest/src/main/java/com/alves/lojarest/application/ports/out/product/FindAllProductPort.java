package com.alves.lojarest.application.ports.out.product;

import com.alves.lojarest.application.domain.models.Product;

import java.util.List;

public interface FindAllProductPort {
    List<Product> findAll();
}
