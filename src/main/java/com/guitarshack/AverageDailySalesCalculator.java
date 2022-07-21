package com.guitarshack;

import java.time.LocalDate;

public class AverageDailySalesCalculator implements AverageDailySales {
    private final LocalDate now;
    private SalesHistory salesHistory;

    public AverageDailySalesCalculator(SalesHistory salesHistory, LocalDate now) {

        this.salesHistory = salesHistory;

        this.now = now;
    }

    @Override
    public double ofProduct(Product product) {
        return salesHistory.totalSales(product.getID(), now.minusDays(30), now)/30.0;
    }
}
