package com.alves.lojarest.common.mappers;

import java.io.Serializable;

public interface AbstractPersistenceMapper
        <Domain extends Serializable,
                Entity extends Serializable> {

    Domain toDomain(Entity Entity);

    Entity toEntity(Domain domain);
}
