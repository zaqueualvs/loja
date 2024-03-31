package com.alves.lojarest.adapter.in.rest.controllers;

import com.alves.lojarest.adapter.in.rest.data.request.TagRequest;
import com.alves.lojarest.adapter.in.rest.data.response.TagResponse;
import com.alves.lojarest.adapter.in.rest.data.response.page.TagPageResponse;
import com.alves.lojarest.adapter.in.rest.mappers.TagRestMapper;
import com.alves.lojarest.application.domain.models.Tag;
import com.alves.lojarest.application.domain.models.page.TagPage;
import com.alves.lojarest.application.ports.in.tag.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "tags")
@RequiredArgsConstructor
public class TagController {

    private final FindAllTagUseCase findAllTagUseCase;
    private final FindTagByIdUseCase findTagByIdUseCase;
    private final FindTagByNameUseCase findTagByNameUseCase;
    private final DeleteTagByIdUseCase deleteTagByIdUseCase;
    private final UpdateTagUseCase updateTagUseCase;
    private final SaveTagUseCase saveTagUseCase;
    private final TagRestMapper tagRestMapper;

    @GetMapping
    public ResponseEntity<TagPageResponse> findAll(
            @RequestParam(defaultValue = "0") @PositiveOrZero Integer page,
            @RequestParam(defaultValue = "5") @PositiveOrZero Integer size
    ) {
        TagPage tagPage = findAllTagUseCase.findAll(page, size);
        TagPageResponse tagPageResponse = tagRestMapper.toPageResponse(tagPage);
        return ResponseEntity.status(HttpStatus.OK).body(tagPageResponse);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<TagResponse> findById(@PathVariable Long id) {
        Tag tag = findTagByIdUseCase.findById(id);
        TagResponse tagResponse = tagRestMapper.toResponse(tag);
        return ResponseEntity.status(HttpStatus.OK).body(tagResponse);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<TagResponse> findByName(@PathVariable String name) {
        Tag tag = findTagByNameUseCase.findByName(name);
        TagResponse tagResponse = tagRestMapper.toResponse(tag);
        return ResponseEntity.status(HttpStatus.OK).body(tagResponse);
    }

    @PostMapping
    public ResponseEntity<TagResponse> save(@RequestBody @Valid TagRequest tagRequest) {
        Tag tag = tagRestMapper.toDomain(tagRequest);
        tag = saveTagUseCase.save(tag);
        TagResponse tagResponse = tagRestMapper.toResponse(tag);
        return ResponseEntity.status(HttpStatus.CREATED).body(tagResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TagResponse> update(@PathVariable Long id,
                                              @RequestBody @Valid TagRequest tagRequest) {
        Tag tag = findTagByIdUseCase.findById(id);
        tagRestMapper.copyProperties(tagRequest, tag);
        tag = updateTagUseCase.update(tag);
        TagResponse tagResponse = tagRestMapper.toResponse(tag);
        return ResponseEntity.status(HttpStatus.CREATED).body(tagResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        deleteTagByIdUseCase.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
