package com.alves.lojarest.application.domain.event;

import java.time.OffsetDateTime;

public class TagEvent {

    private String action;
    private OffsetDateTime data;

    public TagEvent(String action) {
        this.action = action;
        data = OffsetDateTime.now();
    }

    public String getAction() {
        return action;
    }

    public OffsetDateTime getData() {
        return data;
    }


}
