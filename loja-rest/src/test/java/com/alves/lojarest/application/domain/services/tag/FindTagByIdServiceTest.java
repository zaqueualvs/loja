package com.alves.lojarest.application.domain.services.tag;

import com.alves.lojarest.application.domain.exceptions.TagNotFoundException;
import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.out.event.TagEventPublisherPort;
import com.alves.lojarest.application.ports.out.tag.FindTagByIdPort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindTagByIdServiceTest {

    @Mock
    private FindTagByIdPort findTagByIdPort;
    @Mock
    private TagEventPublisherPort tagEventPublisherPort;
    @InjectMocks
    private FindTagByIdService findTagByIdService;

    @Test
    public void findTagById_whenTagIsFound_returnsTag() {
        Tag tag = Instancio.create(Tag.class);
        when(findTagByIdPort.findById(tag.getId())).thenReturn(Optional.of(tag));
        Tag result = findTagByIdService.findById(tag.getId());
        verify(findTagByIdPort, times(1)).findById(tag.getId());
        verifyNoMoreInteractions(findTagByIdPort);
        assertEquals(result, tag);
    }

    @Test
    public void findTagById_whenTagIsNotFound_throwsExceptions() {
        Tag tag = Instancio.create(Tag.class);
        when(findTagByIdPort.findById(tag.getId())).thenReturn(Optional.empty());
        assertThrows(TagNotFoundException.class, () -> findTagByIdService.findById(tag.getId()));
        verify(findTagByIdPort, times(1)).findById(tag.getId());
        verifyNoMoreInteractions(findTagByIdPort);
    }


}