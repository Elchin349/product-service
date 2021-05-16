package com.company.productsapi.repository;

import com.company.productsapi.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ProductRepository extends JpaRepository<Product ,Long> {
    Page<Product> findAllByPriceGreaterThanEqualAndPriceLessThanEqual(Pageable pageable, BigDecimal minPrice,BigDecimal maxPrice);
}
