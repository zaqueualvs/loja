package com.alves.lojalog.application.domain.event;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class TagEvent implements Serializable {

    private String action;
    private OffsetDateTime data;

    public TagEvent() {
    }

    public TagEvent(String action, OffsetDateTime data) {
        this.action = action;
        this.data = data;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public OffsetDateTime getData() {
        return data;
    }

    public void setData(OffsetDateTime data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TagEvent{" +
                "action='" + action + '\'' +
                ", data=" + data +
                '}';
    }
}
