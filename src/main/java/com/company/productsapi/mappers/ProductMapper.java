package com.company.productsapi.mappers;

import com.company.productsapi.dto.ProductResponseDto;
import com.company.productsapi.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductMapper {

    ProductResponseDto toResponseDto(Product product);


}
