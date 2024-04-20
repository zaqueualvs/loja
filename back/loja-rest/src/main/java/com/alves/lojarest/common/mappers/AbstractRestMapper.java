package com.alves.lojarest.common.mappers;

import java.io.Serializable;

public interface AbstractRestMapper
        <D extends Serializable,
                Request extends Serializable,
                Response extends Serializable> {

    D toDomain(Request request);

    Response toResponse(D domain);
}
