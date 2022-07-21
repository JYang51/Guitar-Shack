package com.guitarshack.integrationtests;

import com.guitarshack.ProductWarehouse;
import com.guitarshack.WarehouseTests;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarehouseIntegrationTests extends WarehouseTests {

    @Override
    protected ProductWarehouse createWarehouse() {
        return new ProductWarehouse(new RestTemplate());
    }


}
