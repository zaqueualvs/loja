package com.alves.lojarest.application.domain.exceptions;

public abstract class EntityInUseException extends DomainException{

    public EntityInUseException(String message) {
        super(message);
    }
}
