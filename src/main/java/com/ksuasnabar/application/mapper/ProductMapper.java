package com.ksuasnabar.application.mapper;

import com.ksuasnabar.application.dto.request.ProductCreateRequestDto;
import com.ksuasnabar.application.dto.response.ProductResponseDto;
import com.ksuasnabar.domain.entities.Product;
import com.ksuasnabar.domain.entities.ProductStock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    @Mapping(source = "product.id", target = "id")
    @Mapping(source = "product.name", target = "name")
    @Mapping(source = "product.stock", target = "stock", qualifiedByName = "stockToDouble")
    @Mapping(source = "product.price", target = "price")
    @Mapping(source = "product.creationDate", target = "creationDate")
    @Mapping(source = "product.updateDate", target = "updateDate")
    @Mapping(source = "product.status", target = "status")
    @Mapping(source = "product.category.id", target = "categoryId")
    @Mapping(source = "port", target = "port")
    ProductResponseDto entityToResponse(Product product, Integer port);

    @Mapping(source = "request.name", target = "name")
    @Mapping(source = "request.stock", target = "stock", qualifiedByName = "doubleToProductStock")
    @Mapping(source = "request.price", target = "price")
    @Mapping(source = "request.categoryId", target = "category.id")
    Product requestToEntity(ProductCreateRequestDto request);

    @Named("stockToDouble")
    default Double map(ProductStock stock) {
        return stock != null ? (double) stock.getStock() : null;
    }

    @Named("doubleToProductStock")
    default ProductStock map(Double stock) {
        if (stock != null) {
            return new ProductStock(stock.intValue());
        }
        return null;
    }
}