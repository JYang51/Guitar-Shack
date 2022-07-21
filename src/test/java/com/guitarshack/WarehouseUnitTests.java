package com.guitarshack;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class WarehouseUnitTests extends WarehouseTests{
    @Override
    protected ProductWarehouse createWarehouse() {
        return new ProductWarehouse(new StubRestTemplate());
    }

    private class StubRestTemplate extends RestTemplate {
        @Override
        public <T> T getForObject(URI url, Class<T> responseType) throws RestClientException {
            ProductData productData = new ProductData();
            productData.id = 811;
            return (T) productData;
        }
    }
}
