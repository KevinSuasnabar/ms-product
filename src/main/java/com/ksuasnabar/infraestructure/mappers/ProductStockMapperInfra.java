package com.ksuasnabar.infraestructure.mappers;

import com.ksuasnabar.domain.entities.ProductStock;
import org.mapstruct.Mapper;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface ProductStockMapperInfra {

    default ProductStock toDomain(BigDecimal stock) {
        if (stock == null) {
            return null;
        }
        return new ProductStock(stock.intValue());
    }

    default BigDecimal toEntity(ProductStock productStock) {
        if (productStock == null) {
            return null;
        }
        return BigDecimal.valueOf(productStock.getStock());
    }
}