package com.ksuasnabar.infraestructure.adapters.out.persistance.postgres.product;

import com.ksuasnabar.infraestructure.adapters.out.persistance.postgres.category.entity.CategoryEntity;
import com.ksuasnabar.infraestructure.adapters.out.persistance.postgres.product.entity.DeletedProductEnum;
import com.ksuasnabar.infraestructure.adapters.out.persistance.postgres.product.entity.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ProductRepositoryAdapterTest {

//    @Autowired
//    private ProductRepositoryJpaAdapter productRepositoryAdapter;
//
//    @Test
//    void whenGetAll_ThenReturnAllProduct() {
//        var list = productRepositoryAdapter.findAllByStatus(null);
//        assertEquals(3, list.size());
//    }
//
//    @Test
//    void whenValidSave_ThenReturnProduct() {
//        var productEntity = ProductEntity.builder()
//                .name("Teclado")
//                .stock(Double.valueOf(10))
//                .price(BigDecimal.valueOf(300))
//                .category(CategoryEntity.builder().id(1L).build())
//                .build();
//        productRepositoryAdapter.save(productEntity);
//        var products = productRepositoryAdapter.findByCategoryAndDeleted(productEntity.getCategory(), DeletedProductEnum.CREATED);
//        assertEquals(4,products.size());
//    }
//
//    @Test
//    void whenValidGetId_ThenReturnProduct(){
//        Optional<ProductEntity> productEntity = productRepositoryAdapter.findById(1L);
//        assertTrue(productEntity.isPresent());
//        assertEquals("laptop",productEntity.orElseThrow().getName());
//    }
//
//    @Test
//    void whenInValidGetId_ThenReturnNotFound(){
//        Optional<ProductEntity> productEntity = productRepositoryAdapter.findById(55L);
//        assertThrows(NoSuchElementException.class, productEntity::orElseThrow);
//        assertTrue(productEntity.isEmpty());
//    }
}
