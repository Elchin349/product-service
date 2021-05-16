package com.company.productsapi.mappers;

import com.company.productsapi.dto.request.PriceRequestDto;
import com.company.productsapi.dto.request.ProductRequestDto;
import com.company.productsapi.entity.Price;
import com.company.productsapi.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductUpdateMapper {

    public Product toProduct(Product product, ProductRequestDto productRequestDto) {
        if (productRequestDto.getProductCode() != null) product.setProductCode(productRequestDto.getProductCode());
        if (productRequestDto.getDescription() != null) product.setDescription(productRequestDto.getDescription());
        if (productRequestDto.getCategoryId() != null) product.setCategoryId(productRequestDto.getCategoryId());
        if (productRequestDto.getName() != null) product.setName(productRequestDto.getName());
        if (productRequestDto.getPrice() != null) {
            product.setPrice(toPrice(product.getPrice(), productRequestDto.getPrice()));
        }
        return product;
    }

    public Price toPrice(Price price, PriceRequestDto priceRequestDto) {
        if (priceRequestDto.getPrice() != null) price.setPrice(priceRequestDto.getPrice());
        if (priceRequestDto.getDiscountPrice() != null) price.setDiscountPrice(priceRequestDto.getDiscountPrice());
        if (priceRequestDto.getCurrency() != null) price.setCurrency(priceRequestDto.getCurrency());
        return price;
    }
}
