package com.company.productsapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto implements Serializable {

    private Long id;
    private String name;
    private String description;
    private String productCode;
    private Integer categoryId;
    private PriceResponseDto price;
    private List<ImageResponseDto> images;

}
