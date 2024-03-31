package com.alves.lojarest.adapter.out.persistence.h2.adapters.tag;

import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.out.tag.SaveTagPort;
import com.alves.lojarest.application.ports.out.tag.UpdateTagPort;
import com.alves.lojarest.common.customannotations.EventPublisher;
import lombok.RequiredArgsConstructor;

@EventPublisher
@RequiredArgsConstructor
public class UpdateTagPersistenceAdapter implements UpdateTagPort {

    private final SaveTagPort saveTagPort;

    @Override
    public Tag update(Tag tag) {
        return saveTagPort.save(tag);
    }
}
