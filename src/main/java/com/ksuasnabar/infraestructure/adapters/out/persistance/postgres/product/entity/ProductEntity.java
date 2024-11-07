package com.ksuasnabar.infraestructure.adapters.out.persistance.postgres.product.entity;

import com.ksuasnabar.infraestructure.adapters.out.persistance.postgres.category.entity.CategoryEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    private Double stock;

    @CreationTimestamp
    private LocalDateTime creationDate;

    @UpdateTimestamp
    private LocalDateTime updateTime;

    private ProductStatusEnum status;

    private DeletedProductEnum deleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @PrePersist
    void setPrePersist(){
        status = ProductStatusEnum.NEW;
        deleted = DeletedProductEnum.CREATED;
    }
}























