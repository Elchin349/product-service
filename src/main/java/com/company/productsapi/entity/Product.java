package com.company.productsapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(schema = "product", name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    private Integer stockCount;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_image",referencedColumnName = "id",
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "product_image_fk"))
    private List<Image> images;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_price_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "product_price_fk"))
    private Price price;

    @PrePersist
    private void createDateNow() {
        this.createdDate = LocalDateTime.now();
    }

    @PostUpdate
    private void updatedDateNow() {
        this.updatedDate = LocalDateTime.now();
    }

}
