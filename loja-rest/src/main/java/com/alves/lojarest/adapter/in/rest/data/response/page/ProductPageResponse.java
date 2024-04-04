package com.alves.lojarest.adapter.in.rest.data.response.page;

import com.alves.lojarest.adapter.in.rest.data.response.ProductResponse;
import com.alves.lojarest.application.domain.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductPageResponse implements Serializable {

    private List<ProductResponse> products = new ArrayList<>();
    private Long totalElements;
    private Integer totalPages;

}
