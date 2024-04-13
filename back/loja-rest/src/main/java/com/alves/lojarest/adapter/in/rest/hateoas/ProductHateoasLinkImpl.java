package com.alves.lojarest.adapter.in.rest.hateoas;

import com.alves.lojarest.adapter.in.rest.controllers.ProductController;
import com.alves.lojarest.adapter.in.rest.data.response.ProductResponse;
import com.alves.lojarest.adapter.in.rest.data.response.ProductSimplifiedResponse;
import com.alves.lojarest.common.customannotations.HateoasLink;
import com.alves.lojarest.common.hateoas.ProductHateoasLink;
import com.alves.lojarest.common.hateoas.TagHateoasLink;
import org.springframework.context.annotation.Lazy;
import org.springframework.hateoas.Link;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@HateoasLink
public class ProductHateoasLinkImpl implements ProductHateoasLink {

    private final TagHateoasLink tagHateoasLink;

    public ProductHateoasLinkImpl(@Lazy TagHateoasLink tagHateoasLink) {
        this.tagHateoasLink = tagHateoasLink;
    }

    @Override
    public void addLinkToProductRespose(ProductResponse productResponse) {
        productResponse.add(addLinkFindAll());
        productResponse.add(addLinkFindByName(productResponse.getName()));
        productResponse.add(addLinkFindById(productResponse.getId()));
        productResponse.add(addLinkUpdateProduct(productResponse.getId()));
        productResponse.add(addLinkDeleteProduct(productResponse.getId()));
        productResponse.add(addLinkSaveProduct());
        productResponse.getTags().forEach(tagHateoasLink::addLinkToTagSimplifiedResponse);
    }

    @Override
    public void addLinkToProductSimplifiedResponse(ProductSimplifiedResponse productSimplifiedResponse) {
        productSimplifiedResponse.add(addLinkFindAll());
        productSimplifiedResponse.add(addLinkFindByName(productSimplifiedResponse.getName()));
        productSimplifiedResponse.add(addLinkFindById(productSimplifiedResponse.getId()));
        productSimplifiedResponse.add(addLinkUpdateProduct(productSimplifiedResponse.getId()));
        productSimplifiedResponse.add(addLinkDeleteProduct(productSimplifiedResponse.getId()));
        productSimplifiedResponse.add(addLinkSaveProduct());

    }

    private Link addLinkFindAll() {
        return linkTo(methodOn(ProductController.class)
                .findAll(0, 5))
                .withRel("all products")
                .withType("GET");
    }

    private Link addLinkFindById(Long id) {
        return linkTo(methodOn(ProductController.class)
                .findById(id))
                .withSelfRel()
                .withType("GET");
    }

    private Link addLinkFindByName(String name) {
        return linkTo(methodOn(ProductController.class)
                .findByName(name))
                .withSelfRel()
                .withType("GET");
    }

    private Link addLinkSaveProduct() {
        return linkTo(ProductController.class)
                .withRel("save")
                .withType("POST");
    }

    private Link addLinkUpdateProduct(Long id) {
        return linkTo(ProductController.class)
                .slash("/" + id)
                .withSelfRel()
                .withType("PUT");
    }

    private Link addLinkDeleteProduct(Long id) {
        return linkTo(ProductController.class)
                .slash("/" + id)
                .withSelfRel()
                .withType("DELETE");
    }

}
