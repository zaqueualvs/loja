package com.alves.lojarest.application.domain.services.tag;

import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.out.event.TagEventPublisherPort;
import com.alves.lojarest.application.ports.out.tag.SaveTagPort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SaveTagServiceTest {

    @Mock
    private SaveTagPort saveTagPort;
    @Mock
    private TagEventPublisherPort tagEventPublisherPort;
    @InjectMocks
    private SaveTagService saveTagService;

    @Test
    public void saveTag_whenSaveIt_returnTag() {
        Tag tag = Instancio.create(Tag.class);
        when(saveTagPort.save(tag)).thenReturn(tag);
        Tag result = saveTagService.save(tag);
        verify(saveTagPort, times(1)).save(tag);
        verifyNoMoreInteractions(saveTagPort);
        assertEquals(result, tag);
    }

}