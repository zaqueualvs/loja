package com.alves.lojarest.application.domain.services.tag;

import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.in.tag.FindAllTagUseCase;
import com.alves.lojarest.application.ports.out.tag.FindAllTagPort;
import com.alves.lojarest.common.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindAllTagService implements FindAllTagUseCase {

    private final FindAllTagPort findAllTagPort;

    @Override
    public List<Tag> findAll() {
        return findAllTagPort.findAll();
    }
}
