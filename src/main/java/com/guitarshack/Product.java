package com.guitarshack;

public class Product {
    private final int stockLevel;

    public Product(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public int getStockLevel() {
        return stockLevel;
    }
}
