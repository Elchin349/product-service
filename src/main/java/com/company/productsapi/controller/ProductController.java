package com.company.productsapi.controller;

import com.company.productsapi.container.CrossSafeRestResource;
import com.company.productsapi.container.api.ApiBuilder;
import com.company.productsapi.container.api.SingleMessage;
import com.company.productsapi.dto.ProductPageList;
import com.company.productsapi.dto.ProductResponseDto;
import com.company.productsapi.dto.request.ProductRequestDto;
import com.company.productsapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@CrossSafeRestResource(path = "/api/product")
@RequiredArgsConstructor
public class ProductController implements ApiBuilder {

    private final ProductService productService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<SingleMessage<ProductResponseDto>> save(@RequestPart("product") String product, @RequestPart("files") MultipartFile[] files) {
        return ResponseEntity.ok(generateSingleMessage(productService.getJsonAndSave(product, files)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SingleMessage<ProductResponseDto>> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(generateSingleMessage(productService.getProductById(id)));
    }

    @GetMapping
    public ResponseEntity<SingleMessage<ProductPageList>> getAllProducts(@RequestParam(name = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
                                                                         @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                                                         @RequestParam(name = "minPrice", required = false, defaultValue = "0") BigDecimal minPrice,
                                                                         @RequestParam(name = "maxPrice", required = false, defaultValue = "5000") BigDecimal maxPrice) {
        return ResponseEntity.ok(generateSingleMessage(productService.getAllProducts(pageNumber, pageSize, minPrice, maxPrice)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SingleMessage<ProductResponseDto>> update(@PathVariable Long id, @RequestBody ProductRequestDto productRequestDto) {
        return ResponseEntity.ok(generateSingleMessage(productService.updateProduct(id, productRequestDto)));
    }

}
