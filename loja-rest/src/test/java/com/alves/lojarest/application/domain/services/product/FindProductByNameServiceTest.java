package com.alves.lojarest.application.domain.services.product;

import com.alves.lojarest.application.domain.exceptions.ProductNotFoundException;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.out.event.ProductEventPublisherPort;
import com.alves.lojarest.application.ports.out.product.FindProductByNamePort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindProductByNameServiceTest {

    @Mock
    private FindProductByNamePort findProductByNamePort;
    @Mock
    private ProductEventPublisherPort productEventPublisherPort;
    @InjectMocks
    private FindProductByNameService findProductByNameService;

    @Test
    public void findProductWithName_WhenItExists() {
        Product product = Instancio.create(Product.class);
        when(findProductByNamePort.findByName(anyString())).thenReturn(Optional.of(product));

        Product newProduct = findProductByNameService.findByName(anyString());
        verify(findProductByNamePort, times(1)).findByName(anyString());
        verifyNoMoreInteractions(findProductByNamePort);

        assertNotNull(newProduct);
        assertEquals(newProduct.getId(), product.getId());
        assertEquals(newProduct.getName(), product.getName());
        assertEquals(newProduct.getDescription(), product.getDescription());
        assertEquals(newProduct.getTags().size(), product.getTags().size());
        assertEquals(newProduct.getTargetMarket(), product.getTargetMarket());
    }

    @Test
    public void findProductWithName_WhenItDoesntExists() {
        when(findProductByNamePort.findByName(anyString())).thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, () -> findProductByNameService.findByName(anyString()));
        verify(findProductByNamePort, times(1)).findByName(anyString());
        verifyNoMoreInteractions(findProductByNamePort);
    }

}