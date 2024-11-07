package com.ksuasnabar.infraestructure.adapters.out.persistance.postgres.category.repository;

import com.ksuasnabar.infraestructure.adapters.out.persistance.postgres.category.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
