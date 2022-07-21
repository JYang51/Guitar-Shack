package com.guitarshack;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class SalesHistoryTest {
    @Test
    void returnsCorrectTotalForSpecificDates() {
        SalesHistory salesHistory = createSalesHistory();
        assertEquals(11, salesHistory.totalSales(757, LocalDate.of(2021, Month.JULY, 17), LocalDate.of(2021, Month.JULY, 27)));
    }

    protected abstract ProductSalesHistory createSalesHistory();
}
