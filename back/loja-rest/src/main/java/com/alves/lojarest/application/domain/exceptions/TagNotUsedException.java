package com.alves.lojarest.application.domain.exceptions;

public class TagNotUsedException extends EntityNotUsedException {
    public TagNotUsedException(String message) {
        super(message);
    }

    public TagNotUsedException(Long id) {
        super(String.format("tag with id %d is not used", id));
    }
}
