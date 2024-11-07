package com.ksuasnabar.infraestructure.mappers;

import com.ksuasnabar.domain.entities.DeletedProduct;
import com.ksuasnabar.domain.entities.Product;
import com.ksuasnabar.domain.entities.ProductStatus;
import com.ksuasnabar.infraestructure.adapters.out.persistance.postgres.product.entity.DeletedProductEnum;
import com.ksuasnabar.infraestructure.adapters.out.persistance.postgres.product.entity.ProductEntity;
import com.ksuasnabar.infraestructure.adapters.out.persistance.postgres.product.entity.ProductStatusEnum;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {CategoryMapperInfra.class, ProductStockMapperInfra.class})
public interface ProductMapperInfra {
    ProductStatusEnum toEntityStatus(ProductStatus status);

    ProductStatus toDomainStatus(ProductStatusEnum statusEnum);

    DeletedProduct toEntityDeletedProduct(DeletedProductEnum deletedProductEnum);

    DeletedProductEnum toDomainDeletedProduct(DeletedProduct deletedProduct);

    Product entityToDomain(ProductEntity productEntity);

    ProductEntity domainToEntity(Product product);

}
