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
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class TagResponse extends RepresentationModel<TagResponse> implements Serializable {
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private List<ProductSimplifiedResponse> products = new ArrayList<>();
}
