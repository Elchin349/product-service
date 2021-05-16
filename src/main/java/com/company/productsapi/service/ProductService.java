package com.company.productsapi.service;

import com.company.productsapi.dto.ProductPageList;
import com.company.productsapi.dto.ProductResponseDto;
import com.company.productsapi.dto.request.ProductRequestDto;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public interface ProductService {

    ProductResponseDto getJsonAndSave(String product, MultipartFile[] files);

    ProductResponseDto getProductById(Long id);

    ProductPageList getAllProducts(Integer pageNumber, Integer pageSize, BigDecimal minPrice,BigDecimal maxPrice);

    ProductResponseDto updateProduct(Long id, ProductRequestDto requestDto);
}
