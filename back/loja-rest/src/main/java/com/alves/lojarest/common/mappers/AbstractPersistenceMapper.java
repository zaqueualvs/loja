package com.alves.lojarest.common.mappers;

import java.io.Serializable;

public interface AbstractPersistenceMapper
        <D extends Serializable,
                E extends Serializable> {

    D toDomain(E entity);

    E toEntity(D domain);
}
