package com.ksuasnabar.infraestructure.adapters.out.persistance.postgres.product.repository;

import com.ksuasnabar.infraestructure.adapters.out.persistance.postgres.category.entity.CategoryEntity;
import com.ksuasnabar.infraestructure.adapters.out.persistance.postgres.product.entity.DeletedProductEnum;
import com.ksuasnabar.infraestructure.adapters.out.persistance.postgres.product.entity.ProductEntity;
import com.ksuasnabar.infraestructure.adapters.out.persistance.postgres.product.entity.ProductStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("from ProductEntity where deleted = com.ksuasnabar.infraestructure.adapters.out.persistance.postgres.product.entity.DeletedProductEnum.CREATED and ((:status IS NULL) OR (status =: status))")
    List<ProductEntity> findAllByStatus(@Param("status") ProductStatusEnum status);

    List<ProductEntity> findByCategoryAndDeleted(CategoryEntity category, DeletedProductEnum deletedProductEnum);

}
