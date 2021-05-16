package com.company.productsapi.dto;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ProductPageList extends PageImpl<ProductResponseDto> implements Serializable {

    private static final long serialVersionUID = -1702224335728016175L;
    private final int totalPages;
    private final long totalElements;

    public ProductPageList(List<ProductResponseDto> content, int totalPages, long totalElements) {
        super(content);
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    @Override
    public int getTotalPages() {
        return totalPages;
    }

    @Override
    public long getTotalElements() {
        return totalElements;
    }
}
