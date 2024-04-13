package com.alves.lojarest.application.domain.services.tag;

import com.alves.lojarest.application.domain.exceptions.TagNotFoundException;
import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.out.event.TagEventPublisherPort;
import com.alves.lojarest.application.ports.out.tag.FindTagByNamePort;
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
class FindTagByNameServiceTest {

    @Mock
    private FindTagByNamePort findTagByNamePort;

    @Mock
    private TagEventPublisherPort tagEventPublisherPort;
    @InjectMocks
    private FindTagByNameService findTagByNameService;

    @Test
    void findByName_whenTagIsFound_returnTag() {
        Tag tag = Instancio.create(Tag.class);
        when(findTagByNamePort.findByName(tag.getName())).thenReturn(Optional.of(tag));
        Tag result = findTagByNameService.findByName(tag.getName());
        verify(findTagByNamePort, times(1)).findByName(tag.getName());
        verifyNoMoreInteractions(findTagByNamePort);
        assertEquals(result, tag);
    }

    @Test
    void findByName_whenTagIsNotFound_throwsExceptions() {
        Tag tag = Instancio.create(Tag.class);
        when(findTagByNamePort.findByName(tag.getName())).thenReturn(Optional.empty());
        assertThrows(TagNotFoundException.class, () -> findTagByNameService.findByName(tag.getName()));
        verify(findTagByNamePort, times(1)).findByName(tag.getName());
        verifyNoMoreInteractions(findTagByNamePort);
    }
}