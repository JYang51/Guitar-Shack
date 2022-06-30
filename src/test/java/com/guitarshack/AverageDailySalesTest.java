package com.guitarshack;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AverageDailySalesTest {
    @Test
    void averageCalculatedIsTotalSalesDividedByDays(){
        SalesHistory salesHistory = mock(SalesHistory.class);
        when(salesHistory.totalSales(4)).thenReturn(12);
        AverageDailySales averageDailySales = new AverageDailySalesCalculator(salesHistory);
        Product product = new Product(5, "agarg", 6, 4);
        double averageSales = averageDailySales.ofProduct(product);

        assertEquals(1.2, averageSales, 0);
    }
}
