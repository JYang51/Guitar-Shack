package com.guitarshack;

import java.time.LocalDate;

public class AverageDailySalesCalculator implements AverageDailySales {
    private SalesHistory salesHistory;

    public AverageDailySalesCalculator(SalesHistory salesHistory) {

        this.salesHistory = salesHistory;

    }

    @Override
    public double ofProduct(Product product) {
        return salesHistory.totalSales(product.getID(), LocalDate.now().minusDays(10), null)/10.0;
    }
}
