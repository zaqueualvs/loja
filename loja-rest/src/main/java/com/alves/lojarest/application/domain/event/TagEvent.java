package com.alves.lojarest.application.domain.event;

import java.time.OffsetDateTime;

public class TagEvent {

    private String message;
    private OffsetDateTime data;

    public TagEvent(String message) {
        this.message = message;
        data = OffsetDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public OffsetDateTime getData() {
        return data;
    }


}
