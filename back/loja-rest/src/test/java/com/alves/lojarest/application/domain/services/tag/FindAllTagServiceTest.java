package com.alves.lojarest.application.domain.services.tag;

import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.domain.models.page.TagPage;
import com.alves.lojarest.application.ports.out.event.TagEventPublisherPort;
import com.alves.lojarest.application.ports.out.tag.FindAllTagPort;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindAllTagServiceTest {

    @Mock
    private FindAllTagPort findAllTagPort;
    @Mock
    private TagEventPublisherPort tagEventPublisherPort;
    @InjectMocks
    private FindAllTagService findAllTagService;

    @Test
    public void findAll() {
        List<Tag> tags = Instancio.stream(Tag.class).limit(12).toList();
        TagPage tagPage = new TagPage(tags, 12L, 2);
        when(findAllTagPort.findAll(anyInt(), anyInt())).thenReturn(tagPage);
        TagPage result = findAllTagService.findAll(1, 1);
        verify(findAllTagPort, times(1)).findAll(anyInt(), anyInt());
        verifyNoMoreInteractions(findAllTagPort);
        assertEquals(result.getTags().size(), tagPage.getTags().size());
        assertEquals(result.getTotalElements(), tagPage.getTotalElements());
        assertEquals(result.getTotalPages(), tagPage.getTotalPages());
    }
}