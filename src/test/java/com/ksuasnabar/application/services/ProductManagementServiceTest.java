package com.ksuasnabar.application.services;

import com.ksuasnabar.application.mapper.ProductMapper;
import com.ksuasnabar.domain.entities.*;
import com.ksuasnabar.domain.ports.repository.IProductPortRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductManagementServiceTest {

    @Mock
    private IProductPortRepository productPortRepository;

    private ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    private ProductManagementService productManagementService;

    @BeforeEach
    void setup() {
        productManagementService = new ProductManagementService(productPortRepository, mapper);

        var productEntity = Product.builder()
                .id(1L)
                .name("Teclado2")
                .stock(ProductStock.builder().stock(11).build())
                .price(BigDecimal.valueOf(300))
                .category(Category.builder().id(1L).build())
                .deletedProduct(DeletedProduct.CREATED)
                .build();

        var productEntity2 = Product.builder()
                .id(2L)
                .name("Mouse2")
                .stock(ProductStock.builder().stock(10).build())
                .price(BigDecimal.valueOf(50))
                .category(Category.builder().id(1L).build())
                .deletedProduct(DeletedProduct.CREATED)
                .build();

        Mockito.when(productPortRepository.findAll(ProductStatus.NEW)).thenReturn(List.of(productEntity, productEntity2));

    }

    @Test
    public void whenValidGetAllByStatus_ThenReturnListOfProducts() {
        var productsList = productManagementService.findAll(ProductStatus.NEW, 1);
        productsList.stream().forEach(p -> System.out.println("name: " + p.getName()));
        assertEquals(productsList.size(), 2);
    }


}
