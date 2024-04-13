package com.alves.lojarest.application.domain.services.produtotag;

import com.alves.lojarest.application.domain.event.ProductEvent;
import com.alves.lojarest.application.domain.exceptions.TagAlreadyAddedException;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.in.product.FindProductByIdUseCase;
import com.alves.lojarest.application.ports.in.product.UpdateProductUseCase;
import com.alves.lojarest.application.ports.in.produtotag.AddTagToProductUseCase;
import com.alves.lojarest.application.ports.in.tag.FindTagByIdUseCase;
import com.alves.lojarest.application.ports.out.event.ProductEventPublisherPort;
import com.alves.lojarest.common.customannotations.UseCase;
import lombok.AllArgsConstructor;
import org.springframework.dao.InvalidDataAccessApiUsageException;

@UseCase
@AllArgsConstructor
public class AddTagToProductService implements AddTagToProductUseCase {

    private final FindProductByIdUseCase findProductByIdUseCase;
    private final FindTagByIdUseCase findTagByIdUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final ProductEventPublisherPort productEventPublisherPort;

    @Override
    public Product addTag(Long productId, Long tagId) {
        productEventPublisherPort.publisherEvent(new ProductEvent("AddTagToProductService.addTag(Long productId, Long tagId)"));
        Product product = findProductByIdUseCase.findById(productId);
        Tag tag = findTagByIdUseCase.findById(tagId);

        if (product.getTags().contains(tag)) {
            throw new TagAlreadyAddedException(tagId);
        }
        product.getTags().add(tag);
        product = updateProductUseCase.update(product);

        return product;
    }
}
