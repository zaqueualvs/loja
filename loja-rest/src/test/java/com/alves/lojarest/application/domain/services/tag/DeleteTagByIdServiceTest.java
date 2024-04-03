package com.alves.lojarest.application.domain.services.tag;

import com.alves.lojarest.application.domain.event.TagEvent;
import com.alves.lojarest.application.domain.exceptions.TagNotFoundException;
import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.in.tag.FindTagByIdUseCase;
import com.alves.lojarest.application.ports.out.event.TagEventPublisherPort;
import com.alves.lojarest.application.ports.out.tag.DeleteTagPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteTagByIdServiceTest {

    @Mock
    private DeleteTagPort deleteTagPort;

    @Mock
    private FindTagByIdUseCase findTagByIdUseCase;

    @Mock
    private TagEventPublisherPort tagEventPublisherPort;

    @InjectMocks
    private DeleteTagByIdService deleteTagByIdService;

    @Test
    public void deleteTag_WhenItExists() {
        Tag tag = new Tag(1L, "Java", new HashSet<>());
        when(findTagByIdUseCase.findById(anyLong())).thenReturn(tag);
        deleteTagByIdService.deleteById(anyLong());
        verify(findTagByIdUseCase, times(1)).findById(anyLong());
        verify(deleteTagPort, times(1)).delete(tag);
        verifyNoMoreInteractions(findTagByIdUseCase);
        verifyNoMoreInteractions(deleteTagPort);
    }

    @Test
    public void deleteTag_WhenItDoesntExist() {
        Tag tag = new Tag(1L, "Java", new HashSet<>());
        when(findTagByIdUseCase.findById(anyLong())).thenThrow(TagNotFoundException.class);
        assertThrows(TagNotFoundException.class, () -> deleteTagByIdService.deleteById(anyLong()));
        verify(findTagByIdUseCase, times(1)).findById(anyLong());
        verify(deleteTagPort, times(0)).delete(tag);
        verifyNoMoreInteractions(findTagByIdUseCase);
        verifyNoMoreInteractions(deleteTagPort);
    }
}