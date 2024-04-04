package com.alves.lojarest.adapter.in.rest.data.response;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class ProductResponse extends RepresentationModel<ProductResponse> implements Serializable {
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private String description;
    private String targetMarket;
    private List<TagProductResponse> tags = new ArrayList<>();

}
