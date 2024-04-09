package com.alves.lojarest.adapter.in.rest.data.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductRequest implements Serializable {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String targetMarket;
}
