package com.alves.lojarest.application.domain.services.product;

import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.out.event.ProductEventPublisherPort;
import com.alves.lojarest.application.ports.out.product.SaveProductPort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class SaveProductServiceTest {

    @Mock
    private SaveProductPort saveProductPort;
    @Mock
    private ProductEventPublisherPort productEventPublisherPort;
    @InjectMocks
    private SaveProductService saveProductService;

    @Test
    public void saveProduct() {
        Product product = Instancio.create(Product.class);
        when(saveProductPort.save(product)).thenReturn(product);
        Product newProduct = saveProductService.save(product);

        verify(saveProductPort, times(1)).save(product);
        verifyNoMoreInteractions(saveProductPort);

        assertNotNull(newProduct);
        assertEquals(newProduct.getName(), product.getName());
        assertEquals(newProduct.getDescription(), product.getDescription());
        assertEquals(newProduct.getTags().size(), product.getTags().size());
        assertEquals(newProduct.getTargetMarket(), product.getTargetMarket());
    }
}