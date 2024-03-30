package com.alves.lojarest.common.mappers;

import java.io.Serializable;

public interface AbstractRestMapper
        <Domain extends Serializable,
                Request extends Serializable,
                Response extends Serializable> {

    Domain toDomain(Request request);

    Response toResponse(Domain domain);
}
