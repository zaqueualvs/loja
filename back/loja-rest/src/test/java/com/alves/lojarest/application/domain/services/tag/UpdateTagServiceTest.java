package com.alves.lojarest.application.domain.services.tag;

import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.out.event.TagEventPublisherPort;
import com.alves.lojarest.application.ports.out.tag.UpdateTagPort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdateTagServiceTest {

    @Mock
    private UpdateTagPort updateTagPort;
    @Mock
    private TagEventPublisherPort tagEventPublisherPort;
    @InjectMocks
    private UpdateTagService updateTagService;

    @Test
    void updateTag_whenUpdate_returnTag() {
        Tag tag = Instancio.create(Tag.class);
        when(updateTagPort.update(tag)).thenReturn(tag);
        Tag result = updateTagService.update(tag);
        verify(updateTagPort, times(1)).update(tag);
        verifyNoMoreInteractions(updateTagPort);
        assertEquals(result, tag);
    }
}