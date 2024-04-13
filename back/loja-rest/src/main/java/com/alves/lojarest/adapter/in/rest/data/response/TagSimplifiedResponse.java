package com.alves.lojarest.adapter.in.rest.data.response;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class TagSimplifiedResponse extends RepresentationModel<TagSimplifiedResponse> implements Serializable {
    @EqualsAndHashCode.Include
    private Long id;
    private String name;
}
