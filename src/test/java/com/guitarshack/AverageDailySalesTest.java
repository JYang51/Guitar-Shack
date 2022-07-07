package com.guitarshack;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class AverageDailySalesTest {
    SalesHistory salesHistory;

    @BeforeEach
    public void setUpSalesHistory() {
        salesHistory = mock(SalesHistory.class);
        when(salesHistory.totalSales(anyInt(), any(), any())).thenReturn(12);
    }

    @Test
    void averageCalculatedIsTotalSalesDividedByDays() {
        AverageDailySales averageDailySales = new AverageDailySalesCalculator(salesHistory);
        Product product = new Product(5, "agarg", 6, 4);
        double averageSales = averageDailySales.ofProduct(product);
        assertEquals(1.2, averageSales, 0);
    }

    @Test
    void startDateUsedIs10DaysAgo() {
        AverageDailySales averageDailySales = new AverageDailySalesCalculator(salesHistory);
        averageDailySales.ofProduct(new Product(4, "", 4, 4));
        verify(salesHistory).totalSales(eq(4), eq(LocalDate.of(2022, Month.JUNE, 27)), any());
    }
}
