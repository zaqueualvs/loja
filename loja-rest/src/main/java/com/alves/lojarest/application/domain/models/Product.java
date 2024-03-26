package com.alves.lojarest.application.domain.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Product {
    private Long id;
    private String name;
    private String description;
    private String targetMarket;
    private Set<Tag> tags = new HashSet<>();

    public Product() {
    }

    public Product(Long id, String name, String description, String targetMarket, Set<Tag> tags) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.targetMarket = targetMarket;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTargetMarket() {
        return targetMarket;
    }

    public void setTargetMarket(String targetMarket) {
        this.targetMarket = targetMarket;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
