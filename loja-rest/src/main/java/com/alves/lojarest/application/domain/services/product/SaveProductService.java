
package com.alves.lojarest.application.domain.services.product;

import com.alves.lojarest.application.domain.event.ProductEvent;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.in.product.SaveProductUseCase;
import com.alves.lojarest.application.ports.out.event.ProductEventPublisherPort;
import com.alves.lojarest.application.ports.out.product.SaveProductPort;
import com.alves.lojarest.common.customannotations.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class SaveProductService implements SaveProductUseCase {

    private final SaveProductPort saveProductPort;
    private final ProductEventPublisherPort productEventPublisherPort;

    @Override
    public Product save(Product product) {
        productEventPublisherPort.publisherEvent(new ProductEvent("SaveProductService.save(Product product)"));
        return saveProductPort.save(product);
    }
}
