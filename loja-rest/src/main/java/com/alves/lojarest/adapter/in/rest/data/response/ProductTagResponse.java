package com.alves.lojarest.adapter.in.rest.data.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductTagResponse {
    private Long id;
    private String name;
    private String description;
    private String targetMarket;

}
