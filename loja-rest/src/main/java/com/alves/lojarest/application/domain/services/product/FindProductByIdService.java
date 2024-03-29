package com.alves.lojarest.application.domain.services.product;

import com.alves.lojarest.application.domain.event.ProductEvent;
import com.alves.lojarest.application.domain.exceptions.ProductNotFoundException;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.in.product.FindProductByIdUseCase;
import com.alves.lojarest.application.ports.out.event.ProductEventPublisherPort;
import com.alves.lojarest.application.ports.out.product.FindProductByIdPort;
import com.alves.lojarest.common.UseCase;
import lombok.RequiredArgsConstructor;


@UseCase
@RequiredArgsConstructor
public class FindProductByIdService implements FindProductByIdUseCase {
    private final FindProductByIdPort findProductByIdPort;
    private final ProductEventPublisherPort productEventPublisher;
    @Override
    public Product findById(Long id) {
        productEventPublisher.publisherEvent(new ProductEvent("FindProductByIdService.findById(id)"));
        return findProductByIdPort.findById(id)
                .orElseThrow(
                        () -> new ProductNotFoundException(id)
                );
    }
}
