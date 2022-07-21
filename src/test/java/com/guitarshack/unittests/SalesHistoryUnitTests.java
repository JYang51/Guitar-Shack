package com.guitarshack.unittests;

import com.guitarshack.ProductSalesHistory;
import com.guitarshack.SalesHistoryTest;
import com.guitarshack.SalesTotal;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class SalesHistoryUnitTests extends SalesHistoryTest {

    @Override
    protected ProductSalesHistory createSalesHistory() {
        return new ProductSalesHistory(new StubRestTemplate());
    }

    private class StubRestTemplate extends RestTemplate {
        @Override
        public <T> T getForObject(URI url, Class<T> responseType) throws RestClientException {
            SalesTotal salesTotal = new SalesTotal();
            salesTotal.total = 11;
            return (T) salesTotal;
        }
    }
}
