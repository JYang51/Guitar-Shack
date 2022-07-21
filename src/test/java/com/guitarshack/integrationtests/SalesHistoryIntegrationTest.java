package com.guitarshack.integrationtests;

import com.guitarshack.ProductSalesHistory;
import com.guitarshack.SalesHistoryTest;
import org.springframework.web.client.RestTemplate;

public class SalesHistoryIntegrationTest extends SalesHistoryTest {

    @Override
    protected ProductSalesHistory createSalesHistory() {
        return new ProductSalesHistory(new RestTemplate());
    }
}
