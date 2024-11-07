package com.ksuasnabar.infraestructure.adapters.out.persistance.postgres.product;


import com.ksuasnabar.domain.entities.Category;
import com.ksuasnabar.domain.entities.DeletedProduct;
import com.ksuasnabar.domain.entities.Product;
import com.ksuasnabar.domain.entities.ProductStatus;
import com.ksuasnabar.domain.ports.repository.IProductPortRepository;
import com.ksuasnabar.infraestructure.adapters.out.persistance.postgres.product.entity.ProductEntity;
import com.ksuasnabar.infraestructure.adapters.out.persistance.postgres.product.repository.ProductRepository;
import com.ksuasnabar.infraestructure.mappers.CategoryMapperInfra;
import com.ksuasnabar.infraestructure.mappers.ProductMapperInfra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductRepositoryAdapter implements IProductPortRepository {

    private final ProductRepository productRepository;
    private final ProductMapperInfra productMapper;
    private final CategoryMapperInfra categoryMapper;

    @Autowired
    public ProductRepositoryAdapter(final ProductRepository productRepository, final ProductMapperInfra productMapper, final CategoryMapperInfra categoryMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<Product> findAll(ProductStatus status) {
        List<ProductEntity> products = productRepository.findAllByStatus(productMapper.toEntityStatus(status));
        return products.stream().map(productMapper::entityToDomain).collect(Collectors.toList());
    }

    @Override
    public List<Product> findByCategoryAndDeleted(Category category, DeletedProduct deleted) {
        List<ProductEntity> products = productRepository.findByCategoryAndDeleted(categoryMapper.domainToEntity(category), productMapper.toDomainDeletedProduct(deleted));
        return products.stream().map(productMapper::entityToDomain).collect(Collectors.toList());
    }
}
