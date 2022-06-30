package com.guitarshack;

public class Product {
    private final int stockLevel;
    private String description;

    public Product(int stockLevel, String description) {
        this.stockLevel = stockLevel;
        this.description = description;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public String getDescription() {
        return description;
    }
}
