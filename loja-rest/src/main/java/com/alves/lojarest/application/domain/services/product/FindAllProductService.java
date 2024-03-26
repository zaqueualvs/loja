package com.alves.lojarest.application.domain.services.product;

import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.in.product.FindAllProductUseCase;
import com.alves.lojarest.common.UseCase;

import java.util.List;
@UseCase
public class FindAllProductService implements FindAllProductUseCase {

    @Override
    public List<Product> findAll() {
        return null;
    }
}
