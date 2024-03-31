package com.alves.lojarest.adapter.in.rest.controllers;

import com.alves.lojarest.adapter.in.rest.data.request.ProductRequest;
import com.alves.lojarest.adapter.in.rest.data.response.ProductResponse;
import com.alves.lojarest.adapter.in.rest.data.response.page.ProductPageResponse;
import com.alves.lojarest.adapter.in.rest.mappers.ProductRestMapper;
import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.domain.models.page.ProductPage;
import com.alves.lojarest.application.ports.in.product.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "products")
@RequiredArgsConstructor
public class ProductController {

    private final FindProductByIdUseCase findProductByIdUseCase;
    private final FindAllProductUseCase findAllProductUseCase;
    private final FindProductByNameUseCase findProductByNameUseCase;
    private final SaveProductUseCase saveProductUseCase;
    private final DeleteProductByIdUseCase deleteProductByIdUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final ProductRestMapper productRestMapper;


    @GetMapping
    public ResponseEntity<ProductPageResponse> findAll(
            @RequestParam(defaultValue = "0") @PositiveOrZero Integer page,
            @RequestParam(defaultValue = "5") @PositiveOrZero Integer size
    ) {
        ProductPage productPage = findAllProductUseCase.findAll(page, size);
        ProductPageResponse productPageResponse = productRestMapper.toPageResponse(productPage);
        return ResponseEntity.status(HttpStatus.OK).body(productPageResponse);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        Product product = findProductByIdUseCase.findById(id);
        ProductResponse productResponse = productRestMapper.toResponse(product);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @GetMapping("name/{name}")
    public ResponseEntity<ProductResponse> findByName(@PathVariable String name) {
        Product product = findProductByNameUseCase.findByName(name);
        ProductResponse productResponse = productRestMapper.toResponse(product);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @PostMapping
    public ResponseEntity<ProductResponse> save(@RequestBody @Valid ProductRequest productRequest) {
        Product product = productRestMapper.toDomain(productRequest);
        product = saveProductUseCase.save(product);
        ProductResponse productResponse = productRestMapper.toResponse(product);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id,
                                                  @RequestBody @Valid ProductRequest productRequest) {
        Product product = findProductByIdUseCase.findById(id);
        productRestMapper.copyProperties(productRequest, product);
        product = updateProductUseCase.update(product);
        ProductResponse productResponse = productRestMapper.toResponse(product);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        deleteProductByIdUseCase.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
