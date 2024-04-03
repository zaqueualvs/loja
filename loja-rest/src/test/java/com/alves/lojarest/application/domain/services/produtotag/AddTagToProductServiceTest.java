package com.alves.lojarest.application.domain.services.produtotag;

import com.alves.lojarest.application.domain.exceptions.ProductNotFoundException;
import com.alves.lojarest.application.domain.exceptions.TagNotFoundException;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.in.product.FindProductByIdUseCase;
import com.alves.lojarest.application.ports.in.product.UpdateProductUseCase;
import com.alves.lojarest.application.ports.in.tag.FindTagByIdUseCase;
import com.alves.lojarest.application.ports.out.event.ProductEventPublisherPort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddTagToProductServiceTest {

    @Mock
    private FindProductByIdUseCase findProductByIdUseCase;
    @Mock
    private FindTagByIdUseCase findTagByIdUseCase;
    @Mock
    private UpdateProductUseCase updateProductUseCase;
    @Mock
    private ProductEventPublisherPort productEventPublisherPort;
    @InjectMocks
    private AddTagToProductService addTagToProductService;

    @Test
    public void addTagFromProduct_whenTagAndProductExist() {
        Tag tag = Instancio.create(Tag.class);
        Product product = Instancio.create(Product.class);
        when(findProductByIdUseCase.findById(product.getId())).thenReturn(product);
        when(findTagByIdUseCase.findById(tag.getId())).thenReturn(tag);

        product.getTags().add(tag);
        tag.getProducts().add(product);
        when(updateProductUseCase.update(product)).thenReturn(product);

        Product result = addTagToProductService.addTag(product.getId(), tag.getId());
        verify(findProductByIdUseCase, times(1)).findById(product.getId());
        verify(findTagByIdUseCase, times(1)).findById(tag.getId());
        verify(updateProductUseCase, times(1)).update(product);
        verifyNoMoreInteractions(findProductByIdUseCase);
        verifyNoMoreInteractions(findTagByIdUseCase);
        verifyNoMoreInteractions(updateProductUseCase);
        assertTrue(result.getTags().contains(tag));
    }

    @Test
    public void addTagFromProduct_whenProductDoentExist_ThrowsException() {
        Tag tag = Instancio.create(Tag.class);
        Product product = Instancio.create(Product.class);
        when(findProductByIdUseCase.findById(product.getId())).thenThrow(ProductNotFoundException.class);

        assertThrows(ProductNotFoundException.class, () -> addTagToProductService.addTag(product.getId(), tag.getId()));


        verify(findProductByIdUseCase, times(1)).findById(product.getId());
        verify(findTagByIdUseCase, times(0)).findById(tag.getId());
        verify(updateProductUseCase, times(0)).update(product);
        verifyNoMoreInteractions(findProductByIdUseCase);
        verifyNoMoreInteractions(findTagByIdUseCase);
        verifyNoMoreInteractions(updateProductUseCase);

    }

    @Test
    public void addTagFromProduct_whenTagDoentExist_ThrowsException() {
        Tag tag = Instancio.create(Tag.class);
        Product product = Instancio.create(Product.class);
        when(findProductByIdUseCase.findById(product.getId())).thenReturn(product);
        when(findTagByIdUseCase.findById(tag.getId())).thenThrow(TagNotFoundException.class);

        assertThrows(TagNotFoundException.class, () -> addTagToProductService.addTag(product.getId(), tag.getId()));

        verify(findProductByIdUseCase, times(1)).findById(product.getId());
        verify(findTagByIdUseCase, times(1)).findById(tag.getId());
        verify(updateProductUseCase, times(0)).update(product);
        verifyNoMoreInteractions(findProductByIdUseCase);
        verifyNoMoreInteractions(findTagByIdUseCase);
        verifyNoMoreInteractions(updateProductUseCase);
    }

}