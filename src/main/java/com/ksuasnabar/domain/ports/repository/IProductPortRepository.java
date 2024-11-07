package com.ksuasnabar.domain.ports.repository;

import com.ksuasnabar.domain.entities.Category;
import com.ksuasnabar.domain.entities.DeletedProduct;
import com.ksuasnabar.domain.entities.Product;
import com.ksuasnabar.domain.entities.ProductStatus;

import java.util.List;

public interface IProductPortRepository {
    List<Product> findAll(ProductStatus status);
    List<Product> findByCategoryAndDeleted(Category category, DeletedProduct deleted);
}
