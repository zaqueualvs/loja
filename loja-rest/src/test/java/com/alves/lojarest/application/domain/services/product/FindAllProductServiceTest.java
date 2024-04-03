package com.alves.lojarest.application.domain.services.product;

import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.domain.models.page.ProductPage;
import com.alves.lojarest.application.ports.out.event.ProductEventPublisherPort;
import com.alves.lojarest.application.ports.out.product.FindAllProductPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindAllProductServiceTest {

    @Mock
    private FindAllProductPort findAllProductPort;
    @Mock
    private ProductEventPublisherPort productEventPublisherPort;
    @InjectMocks
    private FindAllProductService findAllProductService;

    @Test
    public void findAllProducs_whenExistProducs() {
        List<Product> products = List.of(
                new Product(),
                new Product(),
                new Product(),
                new Product()
        );
        ProductPage productPage = new ProductPage(products, Long.parseLong(String.valueOf(products.size())), 1);
        when(findAllProductPort.findAll(anyInt(), anyInt())).thenReturn(productPage);
        ProductPage newProductPage = findAllProductService.findAll(1, 4);
        verify(findAllProductPort, times(1)).findAll(anyInt(), anyInt());
        verifyNoMoreInteractions(findAllProductPort);
        assertEquals(newProductPage.getProducts().size(), productPage.getProducts().size());
    }

    @Test
    public void findAllProducs_whenDontExistsProduct() {
        ProductPage productPage = new ProductPage(new ArrayList<>(), 0L, 0);
        when(findAllProductPort.findAll(anyInt(), anyInt())).thenReturn(productPage);
        ProductPage newProductPage = findAllProductService.findAll(1, 4);
        verify(findAllProductPort, times(1)).findAll(anyInt(), anyInt());
        verifyNoMoreInteractions(findAllProductPort);
        assertEquals(newProductPage.getProducts().size(), productPage.getProducts().size());
    }
}