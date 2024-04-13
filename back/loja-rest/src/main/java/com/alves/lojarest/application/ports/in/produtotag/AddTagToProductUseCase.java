package com.alves.lojarest.application.ports.in.produtotag;

import com.alves.lojarest.application.domain.models.Product;

public interface AddTagToProductUseCase {

    Product addTag(Long productId, Long tagId);
}
