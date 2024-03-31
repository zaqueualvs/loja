package com.alves.lojarest.adapter.in.rest.data.response.page;

import com.alves.lojarest.adapter.in.rest.data.response.TagResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TagPageResponse {

    private List<TagResponse> tag = new ArrayList<>();
    private Long totalElements;
    private Integer totalPages;

}
