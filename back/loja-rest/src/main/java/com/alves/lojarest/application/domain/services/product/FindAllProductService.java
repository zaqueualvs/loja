package com.alves.lojarest.application.domain.services.product;

import com.alves.lojarest.application.domain.event.ProductEvent;
import com.alves.lojarest.application.domain.models.page.ProductPage;
import com.alves.lojarest.application.ports.in.product.FindAllProductUseCase;
import com.alves.lojarest.application.ports.out.event.ProductEventPublisherPort;
import com.alves.lojarest.application.ports.out.product.FindAllProductPort;
import com.alves.lojarest.common.customannotations.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class FindAllProductService implements FindAllProductUseCase {

    private final FindAllProductPort findAllProductPort;
    private final ProductEventPublisherPort productEventPublisherPort;

    @Override
    public ProductPage findAll(Integer page, Integer size) {
        productEventPublisherPort.publisherEvent(new ProductEvent("FindAllProductService.findAll(Integer page, Integer size)"));
        return findAllProductPort.findAll(page, size);
    }
}
