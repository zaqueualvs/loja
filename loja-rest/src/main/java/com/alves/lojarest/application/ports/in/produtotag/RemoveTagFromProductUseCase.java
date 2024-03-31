package com.alves.lojarest.application.ports.in.produtotag;

import com.alves.lojarest.application.domain.models.Product;

public interface RemoveTagFromProductUseCase {

    Product removeTag(Long productId, Long tagId);
}
