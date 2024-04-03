package com.alves.lojarest.application.domain.services.product;

import com.alves.lojarest.application.domain.exceptions.ProductNotFoundException;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.in.product.FindProductByIdUseCase;
import com.alves.lojarest.application.ports.out.event.ProductEventPublisherPort;
import com.alves.lojarest.application.ports.out.product.DeleteProductPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteProductByIdServiceTest {

    @Mock
    private FindProductByIdUseCase findProductByIdUseCase;
    @Mock
    private DeleteProductPort deleteProductPort;
    @Mock
    private ProductEventPublisherPort productEventPublisherPort;
    @InjectMocks
    private DeleteProductByIdService deleteProductByIdService;

    @Test
    public void deleteProductWhenItExist() {
        Product product = new Product();
        when(findProductByIdUseCase.findById(anyLong())).thenReturn(product);
        deleteProductByIdService.deleteById(anyLong());
        verify(deleteProductPort, times(1)).delete(product);
        verify(findProductByIdUseCase, times(1)).findById(anyLong());
        verifyNoMoreInteractions(deleteProductPort);
        verifyNoMoreInteractions(findProductByIdUseCase);
    }

    @Test
    public void deleteProductWhenItDoesntExist() {
        when(findProductByIdUseCase.findById(anyLong())).thenThrow(ProductNotFoundException.class);
        assertThrows(ProductNotFoundException.class, () -> deleteProductByIdService.deleteById(anyLong()));
        verify(deleteProductPort, times(0)).delete(new Product());
        verify(findProductByIdUseCase, times(1)).findById(anyLong());
        verifyNoMoreInteractions(deleteProductPort);
        verifyNoMoreInteractions(findProductByIdUseCase);
    }

}