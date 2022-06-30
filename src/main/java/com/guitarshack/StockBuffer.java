package com.guitarshack;

public class StockBuffer implements Buffer {
    private final AverageDailySales averageDailySales;

    public StockBuffer(AverageDailySales averageDailySales) {

        this.averageDailySales = averageDailySales;
    }

    @Override
    public int calculate(Product product) {
        return (int) Math.ceil(product.getLeadTime() * averageDailySales.ofProduct(product));
    }
}
