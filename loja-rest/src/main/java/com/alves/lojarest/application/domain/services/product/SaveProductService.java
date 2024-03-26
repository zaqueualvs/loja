
package com.alves.lojarest.application.domain.services.product;

import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.in.product.SaveProductUseCase;
import com.alves.lojarest.common.UseCase;

@UseCase
public class SaveProductService implements SaveProductUseCase {
    @Override
    public Product save(Product product) {
        return null;
    }
}
