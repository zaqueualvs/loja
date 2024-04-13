package com.alves.lojarest.application.domain.exceptions;

public abstract class EntityNotUsedException extends DomainException{

    public EntityNotUsedException(String message) {
        super(message);
    }
}
