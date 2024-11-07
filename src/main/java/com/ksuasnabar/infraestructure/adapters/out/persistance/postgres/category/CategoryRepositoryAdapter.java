package com.ksuasnabar.infraestructure.adapters.out.persistance.postgres.category;

import com.ksuasnabar.domain.ports.repository.ICategoryPortRepository;
import com.ksuasnabar.infraestructure.adapters.out.persistance.postgres.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryRepositoryAdapter implements ICategoryPortRepository {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryRepositoryAdapter(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
