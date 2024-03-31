package com.alves.lojarest.application.domain.services.product;

import com.alves.lojarest.application.domain.event.ProductEvent;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.in.product.UpdateProductUseCase;
import com.alves.lojarest.application.ports.out.event.ProductEventPublisherPort;
import com.alves.lojarest.application.ports.out.product.UpdateProductPort;
import com.alves.lojarest.common.customannotations.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UpdateProductService implements UpdateProductUseCase {

    private final UpdateProductPort updateProductPort;
    private final ProductEventPublisherPort productEventPublisherPort;

    @Override
    public Product update(Product product) {
        productEventPublisherPort.publisherEvent(new ProductEvent("UpdateProductService.update(Product product)"));
        return updateProductPort.update(product);
    }
}
