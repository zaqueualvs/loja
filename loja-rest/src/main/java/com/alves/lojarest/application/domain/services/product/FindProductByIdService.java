package com.alves.lojarest.application.domain.services.product;

import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.in.product.FindProductByIdUseCase;
import com.alves.lojarest.common.UseCase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UseCase
public class FindProductByIdService implements FindProductByIdUseCase {

    @Override
    public Product findById(Long id) {
        log.info("Ping findById");
        return null;
    }
}
