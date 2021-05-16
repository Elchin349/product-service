package com.company.productsapi.service;

import com.company.productsapi.dto.ProductPageList;
import com.company.productsapi.dto.ProductResponseDto;
import com.company.productsapi.dto.request.ProductRequestDto;
import com.company.productsapi.entity.Image;
import com.company.productsapi.entity.Product;
import com.company.productsapi.enums.BusinessStatus;
import com.company.productsapi.exceptions.NotFoundException;
import com.company.productsapi.mappers.ProductMapper;
import com.company.productsapi.mappers.ProductUpdateMapper;
import com.company.productsapi.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductUpdateMapper productUpdateMapper;

    @Override
    public ProductResponseDto getJsonAndSave(String product, MultipartFile[] files) {
        Product productDb = new Product();

        try {

            ObjectMapper objectMapper = new ObjectMapper();
            productDb = objectMapper.readValue(product, Product.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        productDb.setImages(Arrays.stream(files).map(multipartFile -> {
            try {
                return convertImage(multipartFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList()));
        productRepository.save(productDb);
        return productMapper.toResponseDto(productDb);
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.map(productMapper::toResponseDto).orElseThrow(new NotFoundException(BusinessStatus.PRODUCT_BY_ID_NOT_FOUND));
    }

    @Override
    public ProductPageList getAllProducts(Integer pageNumber, Integer pageSize, BigDecimal minPrice, BigDecimal maxPrice) {
        Page<Product> products = productRepository.findAllByPriceGreaterThanEqualAndPriceLessThanEqual(PageRequest.of(pageNumber, pageSize), minPrice, maxPrice);
        return new ProductPageList(products.getContent()
                .stream()
                .map(productMapper::toResponseDto)
                .collect(Collectors.toList()),
                products.getTotalPages(),
                products.getTotalElements());

    }

    @Override
    public ProductResponseDto updateProduct(Long id, ProductRequestDto requestDto) {
        Optional<Product> optional = Optional.ofNullable(productRepository.findById(id).orElseThrow(new NotFoundException(BusinessStatus.PRODUCT_BY_ID_NOT_FOUND)));
        optional.ifPresent(product -> productRepository.save(productUpdateMapper.toProduct(product, requestDto)));
        return getProductById(id);
    }

    public Image convertImage(MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));

        Image image = new Image();
        image.setName(fileName);
        image.setType(multipartFile.getContentType());
        image.setData(multipartFile.getBytes());

        return image;
    }
}
