package com.company.productsapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceResponseDto {

    private BigDecimal price;
    private BigDecimal discountPrice;
    private String currency;
}
