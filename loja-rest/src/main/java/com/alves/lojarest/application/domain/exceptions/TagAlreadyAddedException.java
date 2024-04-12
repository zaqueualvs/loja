package com.alves.lojarest.application.domain.exceptions;

public class TagAlreadyAddedException extends EntityAlreadyAddedException {
    public TagAlreadyAddedException(String message) {
        super(message);
    }

    public TagAlreadyAddedException(Long id) {
        super(String.format("tag with id %s already added.", id));
    }
}