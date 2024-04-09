package com.alves.lojarest.application.domain.services.product;

import com.alves.lojarest.application.domain.event.ProductEvent;
import com.alves.lojarest.application.domain.exceptions.ProductInUseException;
import com.alves.lojarest.application.domain.exceptions.ProductNotFoundException;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.in.product.DeleteProductByIdUseCase;
import com.alves.lojarest.application.ports.in.product.FindProductByIdUseCase;
import com.alves.lojarest.application.ports.out.event.ProductEventPublisherPort;
import com.alves.lojarest.application.ports.out.product.DeleteProductPort;
import com.alves.lojarest.application.ports.out.product.FindProductByIdPort;
import com.alves.lojarest.common.customannotations.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataIntegrityViolationException;

@UseCase
@RequiredArgsConstructor
public class DeleteProductByIdService implements DeleteProductByIdUseCase {

    private final FindProductByIdUseCase findProductByIdUseCase;
    private final DeleteProductPort deleteProductPort;
    private final ProductEventPublisherPort productEventPublisherPort;

    @Override
    public void deleteById(Long id) {
        productEventPublisherPort.publisherEvent(new ProductEvent("DeleteProductByIdService.deleteById(Long id)"));
        Product product = findProductByIdUseCase.findById(id);
        try {
            deleteProductPort.delete(product);
        } catch (DataIntegrityViolationException e) {
            throw new ProductInUseException(id);
        }
    }
}
