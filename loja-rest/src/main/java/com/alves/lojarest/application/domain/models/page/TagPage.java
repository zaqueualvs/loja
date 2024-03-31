package com.alves.lojarest.application.domain.models.page;

import com.alves.lojarest.application.domain.models.Product;
import com.alves.lojarest.application.domain.models.Tag;

import java.util.ArrayList;
import java.util.List;

public class TagPage {

    private List<Tag> tags = new ArrayList<>();
    private Long totalElements;
    private Integer totalPages;

    public TagPage() {
    }

    public TagPage(List<Tag> tags, Long totalElements, Integer totalPages) {
        this.tags = tags;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}
