package com.guitarshack;

public class Product {
    private final int stockLevel;
    private String description;
    private final int leadTime;
    private int id;

    public Product(int stockLevel, String description, int leadTime, int id) {
        this.stockLevel = stockLevel;
        this.description = description;
        this.leadTime = leadTime;
        this.id = id;
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

    public int getID() {
        return id;
    }
}
