package com.ksuasnabar.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long id;
    private String name;
    private ProductStock stock;
    private BigDecimal price;
    private ProductStatus status;
    private DeletedProduct deletedProduct;
    private Category category;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
}
