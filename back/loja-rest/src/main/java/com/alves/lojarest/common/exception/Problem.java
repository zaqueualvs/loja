package com.alves.lojarest.common.exception;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Problem {

    private Integer status;
    private String type;
    private String title;
    private String detail;
    private String userMessage;
    private OffsetDateTime timestamp;
    private List<Object> objects;

    @Builder
    @Getter
    public static class Object {
        private String name;
        private String userMessage;
    }
}
