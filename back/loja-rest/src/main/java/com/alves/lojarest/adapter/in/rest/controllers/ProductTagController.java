package com.alves.lojarest.adapter.in.rest.controllers;

import com.alves.lojarest.adapter.in.rest.data.response.ProductResponse;
import com.alves.lojarest.adapter.in.rest.mappers.ProductRestMapper;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.in.produtotag.AddTagToProductUseCase;
import com.alves.lojarest.application.ports.in.produtotag.RemoveTagFromProductUseCase;
import com.alves.lojarest.common.hateoas.ProductHateoasLink;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@io.swagger.v3.oas.annotations.tags.Tag(name = "ProductTag", description = "api for add tag to product")
@RestController
@RequestMapping(value = "api/products/{productId}/tags/{tagId}")
@AllArgsConstructor
public class ProductTagController {

    private final RemoveTagFromProductUseCase removeTagFromProductUseCase;
    private final AddTagToProductUseCase addTagToProductUseCase;
    private final ProductRestMapper productRestMapper;
    private final ProductHateoasLink productHateoasLink;

    @PutMapping
    public ResponseEntity<ProductResponse> addTag(@PathVariable Long productId,
                                                  @PathVariable Long tagId) {

        Product product = addTagToProductUseCase.addTag(productId, tagId);
        ProductResponse productResponse = productRestMapper.toResponse(product);
        productHateoasLink.addLinkToProductRespose(productResponse);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @DeleteMapping
    public ResponseEntity<ProductResponse> removeTag(@PathVariable Long productId,
                                                     @PathVariable Long tagId) {

        Product product = removeTagFromProductUseCase.removeTag(productId, tagId);
        ProductResponse productResponse = productRestMapper.toResponse(product);
        productHateoasLink.addLinkToProductRespose(productResponse);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }
}
