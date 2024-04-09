package com.alves.lojarest.application.domain.exceptions;

public class ProductInUseException extends EntityInUseException {
    public ProductInUseException(String message) {
        super(message);
    }

    public ProductInUseException(Long id) {
        super(String.format("product with id %d is in use", id));
    }
}