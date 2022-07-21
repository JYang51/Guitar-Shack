package com.guitarshack.unittests;


import com.guitarshack.AverageDailySales;
import com.guitarshack.AverageDailySalesCalculator;
import com.guitarshack.Product;
import com.guitarshack.SalesHistory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class AverageDailySalesTest {
    private final LocalDate now = LocalDate.of(2022, Month.JULY, 7);
    SalesHistory salesHistory;

    @BeforeEach
    public void setUpSalesHistory() {
        salesHistory = mock(SalesHistory.class);
        when(salesHistory.totalSales(anyInt(), any(), any())).thenReturn(12);
    }

    @Test
    void averageCalculatedIsTotalSalesDividedByDays() {
        AverageDailySales averageDailySales = new AverageDailySalesCalculator(salesHistory, now);
        Product product = new Product(5, "agarg", 6, 4);
        double averageSales = averageDailySales.ofProduct(product);
        assertEquals(0.4, averageSales, 0);
    }

    @Test
    void startDateUsedIs30DaysAgo() {
        AverageDailySales averageDailySales = new AverageDailySalesCalculator(salesHistory, now);
        averageDailySales.ofProduct(new Product(4, "", 4, 4));
        verify(salesHistory).totalSales(eq(4), eq(LocalDate.of(2022, Month.JUNE, 7)), any());
    }

    @Test
    void endDateUsedIsToday() {
        AverageDailySales averageDailySales = new AverageDailySalesCalculator(salesHistory, now);
        averageDailySales.ofProduct(new Product(4, "", 4, 4));

        verify(salesHistory).totalSales(anyInt(), any(), eq(now));
    }
}
