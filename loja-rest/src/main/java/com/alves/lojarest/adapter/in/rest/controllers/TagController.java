package com.alves.lojarest.adapter.in.rest.controllers;

import com.alves.lojarest.adapter.in.rest.data.response.TagResponse;
import com.alves.lojarest.adapter.in.rest.mappers.TagRestMapper;
import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.ports.in.tag.FindAllTagUseCase;
import com.alves.lojarest.application.ports.in.tag.FindTagByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "tags")
@RequiredArgsConstructor
public class TagController {

    private final FindAllTagUseCase findAllTagUseCase;
    private final FindTagByIdUseCase findTagByIdUseCase;
    private final TagRestMapper tagRestMapper;

    @GetMapping
    public ResponseEntity<List<TagResponse>> findAll() {
        List<TagResponse> tagResponseList = findAllTagUseCase.findAll()
                .stream()
                .map(tagRestMapper::toResponse)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(tagResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagResponse> findById(@PathVariable Long id) {
        Tag tag = findTagByIdUseCase.findById(id);
        TagResponse tagResponse = tagRestMapper.toResponse(tag);
        return ResponseEntity.status(HttpStatus.OK).body(tagResponse);
    }

}
