package com.alves.lojalog.application.domain.event;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class ProductEvent implements Serializable {

    private String action;
    private OffsetDateTime data;

    public ProductEvent() {
    }

    public ProductEvent(String action, OffsetDateTime data) {
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
        return "ProductEvent{" +
                "action='" + action + '\'' +
                ", data=" + data +
                '}';
    }
}
