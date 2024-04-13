package com.alves.lojarest.adapter.in.rest.data.response.page;

import com.alves.lojarest.adapter.in.rest.data.response.TagResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TagPageResponse implements Serializable {

    private List<TagResponse> tags = new ArrayList<>();
    private Long totalElements;
    private Integer totalPages;

}
