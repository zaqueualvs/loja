package com.alves.lojarest.application.ports.in.product;

import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.domain.models.page.ProductPage;

import java.util.List;

public interface FindAllProductUseCase {
    ProductPage findAll(Integer page, Integer size);
}
