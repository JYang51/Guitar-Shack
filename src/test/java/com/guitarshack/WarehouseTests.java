package com.guitarshack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class WarehouseTests {
    @Test
    public void getProduct() {
        Warehouse warehouse = createWarehouse();
        Product product = warehouse.fetchProduct(811);

        assertEquals(811, product.getID());
    }

    protected abstract ProductWarehouse createWarehouse();
}
