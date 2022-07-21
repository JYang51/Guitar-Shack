package com.guitarshack.integrationtests;

import com.guitarshack.*;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.Month;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GuitarShackIntegrationTest {
    @Test
    public void notificationSent() {
        Notification notification = mock(Notification.class);
        SalesEventHandler salesEventHandler = new SalesEventHandler(
                notification,
                new ProductWarehouse(
                        new RestTemplate()
                ),
                new StockBuffer(
                        new AverageDailySalesCalculator(
                                new ProductSalesHistory(
                                        new RestTemplate()
                                ),
                                LocalDate.of(2021, Month.FEBRUARY, 9)
                        )
                )
        );
        salesEventHandler.onPurchase(811, 100);

        verify(notification).send(any());
    }
}
