package com.guitarshack;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalesHistoryTest {
    @Test
    void returnsCorrectTotalForSpecificDates() {
        SalesHistory salesHistory = new ProductSalesHistory();
        assertEquals(22, salesHistory.totalSales(811, LocalDate.of(2021, Month.JULY, 17), LocalDate.of(2021, Month.JULY, 27)));
    }
}
