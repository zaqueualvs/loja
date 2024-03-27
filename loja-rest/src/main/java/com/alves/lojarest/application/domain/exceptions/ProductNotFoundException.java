package com.alves.lojarest.application.domain.exceptions;

public class ProductNotFoundException extends EntityNotFoundException {
    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(Long id) {
        super(String.format("There is no product registration with id %d.", id));
    }
}
