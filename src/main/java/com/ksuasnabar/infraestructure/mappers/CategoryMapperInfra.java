package com.ksuasnabar.infraestructure.mappers;

import com.ksuasnabar.domain.entities.Category;
import com.ksuasnabar.infraestructure.adapters.out.persistance.postgres.category.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapperInfra {
    CategoryEntity domainToEntity(Category category);
    Category entityToDomain(CategoryEntity categoryEntity);
}
