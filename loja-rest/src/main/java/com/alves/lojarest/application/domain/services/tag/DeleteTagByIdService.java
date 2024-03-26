package com.alves.lojarest.application.domain.services.tag;

import com.alves.lojarest.application.ports.in.tag.DeleteTagByIdUseCase;
import com.alves.lojarest.common.UseCase;

@UseCase
public class DeleteTagByIdService implements DeleteTagByIdUseCase {

    @Override
    public void deleteById(Long id) {
    }
}
