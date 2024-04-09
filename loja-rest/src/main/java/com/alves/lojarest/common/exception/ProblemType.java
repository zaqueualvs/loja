package com.alves.lojarest.common.exception;

import lombok.Getter;

@Getter
public enum ProblemType {

    INCOMPREHENSIBLE_MESSAGE("Incomprehensible message","Incomprehensible message"),
    SYSTEM_ERROR("system-error", "system error"),
    ENTITY_IN_USE("entity-in-use", "Entity in use"),
    INVALID_PARAMETER("invalid-parameter", "Invalid parameter"),
    METHOD_NOT_SUPPORTED("method-not-supported", "Method not supported"),
    INVALID_DATA("invalid-data", "invalid data"),
    DOMAIN_ERROR("domain-error", "Business rule violation"),
    RESOURCE_NOT_FOUND("resource-not-found", "Resource not found");

    private final String uri;
    private final String title;

    ProblemType(String uri, String title) {
        this.uri = "http://localhost:8080/" + uri;
        this.title = title;
    }
}
