package com.alves.lojarest.application.domain.services.product;

import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.in.product.FindProductByIdUseCase;
import com.alves.lojarest.common.UseCase;

@UseCase
public class FindProductByIdService implements FindProductByIdUseCase {

    @Override
    public Product findById(Long id) {
        return null;
    }
}
