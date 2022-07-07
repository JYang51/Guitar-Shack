package com.guitarshack;

import java.time.LocalDate;

public interface SalesHistory {
    int totalSales(int productID, LocalDate startDate, LocalDate endDate);
}
