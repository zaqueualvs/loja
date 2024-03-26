package com.alves.lojarest.application.domain.services.product;

import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.in.product.FindProductByNameUseCase;
import com.alves.lojarest.common.UseCase;

@UseCase
public class FindProductByNameService implements FindProductByNameUseCase {

    @Override
    public Product findByName(String name) {
        return null;
    }
}
