package com.alves.lojarest.application.domain.services.product;

import com.alves.lojarest.application.domain.exceptions.ProductNotFoundException;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.out.event.ProductEventPublisherPort;
import com.alves.lojarest.application.ports.out.product.FindProductByIdPort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindProductByIdServiceTest {

    @Mock
    private FindProductByIdPort findProductByIdPort;
    @Mock
    private ProductEventPublisherPort productEventPublisherPort;

    @InjectMocks
    private FindProductByIdService findProductByIdService;

    @Test
    public void findProductWithId_WhenExistsReturnProduct() {
        Product product = Instancio.create(Product.class);
        when(findProductByIdPort.findById(product.getId())).thenReturn(Optional.of(product));

        Product newProduct = findProductByIdService.findById(product.getId());
        verify(findProductByIdPort, times(1)).findById(anyLong());
        verifyNoMoreInteractions(findProductByIdPort);

        assertNotNull(newProduct);
        assertEquals(newProduct.getId(), product.getId());
        assertEquals(newProduct.getName(), product.getName());
        assertEquals(newProduct.getDescription(), product.getDescription());

    }

    @Test
    public void findProductWithId_WhenDontExistThrowsException() {
        when(findProductByIdPort.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, () -> findProductByIdService.findById(anyLong()));
        verify(findProductByIdPort, times(1)).findById(anyLong());
        verifyNoMoreInteractions(findProductByIdPort);

    }

}