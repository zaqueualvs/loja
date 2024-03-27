package com.alves.lojarest.application.domain.exceptions;

public abstract class EntityNotFoundException extends DomainException{

    public EntityNotFoundException(String message) {
        super(message);
    }
}
