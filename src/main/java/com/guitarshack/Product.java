package com.guitarshack;

public class Product {
    private final int stockLevel;
    private String description;
    private final int leadTime;

    public Product(int stockLevel, String description, int leadTime) {
        this.stockLevel = stockLevel;
        this.description = description;
        this.leadTime = leadTime;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public String getDescription() {
        return description;
    }

    public int getLeadTime() {
        return leadTime;
    }
}
