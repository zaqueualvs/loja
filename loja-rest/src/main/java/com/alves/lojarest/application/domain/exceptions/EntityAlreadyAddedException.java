package com.alves.lojarest.application.domain.exceptions;

public abstract class EntityAlreadyAddedException extends DomainException{

    public EntityAlreadyAddedException(String message) {
        super(message);
    }
}
