package com.alves.lojarest.application.domain.exceptions;

public class TagInUseException extends EntityInUseException {
    public TagInUseException(String message) {
        super(message);
    }

    public TagInUseException(Long id) {
        super(String.format("tag with id %d is in use", id));
    }
}
