package com.ksuasnabar.domain.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductStock {

    private int stock;

    public ProductStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        this.stock = stock;
    }

    public void increase(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("No se pueden agregar unidades negativas");
        }
        this.stock += quantity;
    }

    public void decrease(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("No se pueden disminuir unidades negativas");
        }

        if (quantity > this.stock) {
            throw new IllegalArgumentException("No se puede disminuir mas que el stock total");

        }

        this.stock -= quantity;
    }

    public boolean stockIsAvailable() {
        return this.stock > 0;
    }

}
