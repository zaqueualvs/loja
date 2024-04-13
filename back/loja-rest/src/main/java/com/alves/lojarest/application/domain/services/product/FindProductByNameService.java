package com.alves.lojarest.application.domain.services.product;

import com.alves.lojarest.application.domain.event.ProductEvent;
import com.alves.lojarest.application.domain.exceptions.ProductNotFoundException;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.in.product.FindProductByNameUseCase;
import com.alves.lojarest.application.ports.out.event.ProductEventPublisherPort;
import com.alves.lojarest.application.ports.out.product.FindProductByNamePort;
import com.alves.lojarest.common.customannotations.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class FindProductByNameService implements FindProductByNameUseCase {

    private final FindProductByNamePort findProductByNamePort;
    private final ProductEventPublisherPort productEventPublisherPort;

    @Override
    public Product findByName(String name) {
        productEventPublisherPort.publisherEvent(new ProductEvent("FindProductByNameService.findByName(String name)"));
        return findProductByNamePort.findByName(name)
                .orElseThrow(
                        () -> new ProductNotFoundException(
                                String.format("There is no product registration with name %s.", name))
                );
    }
}
