package com.alves.lojarest.application.ports.out.product;

import com.alves.lojarest.application.domain.models.page.ProductPage;

public interface FindAllProductPort {
    ProductPage findAll(Integer page, Integer size);
}
