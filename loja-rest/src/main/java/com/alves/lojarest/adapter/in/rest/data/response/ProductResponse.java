package com.alves.lojarest.adapter.in.rest.data.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductResponse implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String targetMarket;
    private Set<TagProductResponse> tags = new HashSet<>();

}
