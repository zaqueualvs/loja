package com.alves.lojarest.application.domain.services.product;

import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.out.event.ProductEventPublisherPort;
import com.alves.lojarest.application.ports.out.product.UpdateProductPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class UpdateProductServiceTest {

    @Mock
    private UpdateProductPort updateProductPort;
    @Mock
    private ProductEventPublisherPort productEventPublisherPort;
    @InjectMocks
    private UpdateProductService updateProductService;
    @Test
    public void updateProduct() {
        Product product = new Product(32L, "Sandalia", "Tipo de calçado para o pé", "Todas as pessoas", new HashSet<>());
        when(updateProductPort.update(product)).thenReturn(product);
        Product newProduct = updateProductService.update(product);

        verify(updateProductPort, times(1)).update(product);
        verifyNoMoreInteractions(updateProductPort);

        assertNotNull(newProduct);
        assertEquals(newProduct.getId(), product.getId());
        assertEquals(newProduct.getName(), product.getName());
        assertEquals(newProduct.getDescription(), product.getDescription());
        assertEquals(newProduct.getTags().size(), product.getTags().size());
        assertEquals(newProduct.getTargetMarket(), product.getTargetMarket());
    }

}