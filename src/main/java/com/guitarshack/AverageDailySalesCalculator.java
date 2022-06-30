package com.guitarshack;

public class AverageDailySalesCalculator implements AverageDailySales {
    private SalesHistory salesHistory;

    public AverageDailySalesCalculator(SalesHistory salesHistory) {

        this.salesHistory = salesHistory;

    }

    @Override
    public double ofProduct(Product product) {
        return salesHistory.totalSales(product.getID())/10.0;
    }
}
