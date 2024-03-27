package com.alves.lojarest.adapter.in.rest.controllers;

import com.alves.lojarest.adapter.in.rest.data.response.ProductResponse;
import com.alves.lojarest.adapter.in.rest.mappers.ProductRestMapper;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.ports.in.product.FindProductByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "products")
@RequiredArgsConstructor
public class ProductController {

    private final FindProductByIdUseCase findProductByIdUseCase;
    private final ProductRestMapper productRestMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        Product product = findProductByIdUseCase.findById(id);
        ProductResponse productResponse = productRestMapper.toResponse(product);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);

    }
}
