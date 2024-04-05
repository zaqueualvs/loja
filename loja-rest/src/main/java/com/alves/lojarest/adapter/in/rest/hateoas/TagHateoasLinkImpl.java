package com.alves.lojarest.adapter.in.rest.hateoas;

import com.alves.lojarest.adapter.in.rest.controllers.TagController;
import com.alves.lojarest.adapter.in.rest.data.response.TagResponse;
import com.alves.lojarest.adapter.in.rest.data.response.TagSimplifiedResponse;
import com.alves.lojarest.common.customannotations.HateoasLink;
import com.alves.lojarest.common.hateoas.ProductHateoasLink;
import com.alves.lojarest.common.hateoas.TagHateoasLink;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@HateoasLink
public class TagHateoasLinkImpl implements TagHateoasLink {

    private final ProductHateoasLink productHateoasLink;

    public TagHateoasLinkImpl(ProductHateoasLink productHateoasLink) {
        this.productHateoasLink = productHateoasLink;
    }

    @Override
    public void addLinkToTagRespose(TagResponse tagResponse) {
        tagResponse.add(addLinkFindAll());
        tagResponse.add(addLinkFindById(tagResponse.getId()));
        tagResponse.add(addLinkFindByName(tagResponse.getName()));
        tagResponse.add(addLinkSaveTag());
        tagResponse.add(addLinkDeleteTag(tagResponse.getId()));
        tagResponse.add(addLinkUpdateTag(tagResponse.getId()));
        tagResponse.getProducts().forEach(productHateoasLink::addLinkToProductSimplifiedResponse);
    }

    @Override
    public void addLinkToTagSimplifiedResponse(TagSimplifiedResponse tagSimplifiedResponse) {
        tagSimplifiedResponse.add(addLinkFindAll());
        tagSimplifiedResponse.add(addLinkFindById(tagSimplifiedResponse.getId()));
        tagSimplifiedResponse.add(addLinkFindByName(tagSimplifiedResponse.getName()));
        tagSimplifiedResponse.add(addLinkSaveTag());
        tagSimplifiedResponse.add(addLinkDeleteTag(tagSimplifiedResponse.getId()));
        tagSimplifiedResponse.add(addLinkUpdateTag(tagSimplifiedResponse.getId()));
    }

    private Link addLinkFindAll() {
        return linkTo(methodOn(TagController.class)
                .findAll(0, 5))
                .withRel("all tags")
                .withType("GET");
    }

    private Link addLinkFindById(Long id) {
        return linkTo(methodOn(TagController.class)
                .findById(id))
                .withSelfRel()
                .withType("GET");
    }

    private Link addLinkFindByName(String name) {
        return linkTo(methodOn(TagController.class)
                .findByName(name))
                .withSelfRel()
                .withType("GET");
    }

    private Link addLinkSaveTag() {
        return linkTo(TagController.class)
                .withRel("save")
                .withType("POST");
    }

    private Link addLinkUpdateTag(Long id) {
        return linkTo(TagController.class)
                .slash("/" + id)
                .withSelfRel()
                .withType("PUT");
    }

    private Link addLinkDeleteTag(Long id) {
        return linkTo(TagController.class)
                .slash("/" + id)
                .withSelfRel()
                .withType("DELETE");
    }
}
