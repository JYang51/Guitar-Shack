package com.guitarshack;

import org.springframework.web.client.RestTemplate;

public class SalesHistoryIntegrationTest extends SalesHistoryTest {

    @Override
    protected ProductSalesHistory createSalesHistory() {
        return new ProductSalesHistory(new RestTemplate());
    }
}
