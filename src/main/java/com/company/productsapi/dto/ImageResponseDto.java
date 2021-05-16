package com.company.productsapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageResponseDto {

    private Long id;
    private byte[] data;
    private String name;
    private String type;

}
