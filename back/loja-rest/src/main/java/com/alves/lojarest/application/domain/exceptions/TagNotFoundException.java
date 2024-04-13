package com.alves.lojarest.application.domain.exceptions;

public class TagNotFoundException extends EntityNotFoundException {
    public TagNotFoundException(String message) {
        super(message);
    }

    public TagNotFoundException(Long id) {
        super(String.format("There is no tag registration with id %d.", id));
    }
}
