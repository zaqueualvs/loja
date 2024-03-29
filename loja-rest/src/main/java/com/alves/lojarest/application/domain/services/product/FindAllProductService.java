package com.alves.lojarest.application.domain.services.product;

import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.in.product.FindAllProductUseCase;
import com.alves.lojarest.application.ports.out.product.FindAllProductPort;
import com.alves.lojarest.common.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindAllProductService implements FindAllProductUseCase {

    private final FindAllProductPort findAllProductPort;

    @Override
    public List<Product> findAll() {
        return findAllProductPort.findAll();
    }
}
