package com.guitarshack;

public class SalesEventHandler {

    private final Notification notification;
    private final Warehouse warehouse;
    private final Buffer bufferCalculator;

    public SalesEventHandler(Notification notification, Warehouse warehouse, Buffer bufferCalculator) {
        this.notification = notification;
        this.warehouse = warehouse;
        this.bufferCalculator = bufferCalculator;
    }

    public void onPurchase(int productID, int quantity) {
        Product product = warehouse.fetchProduct(productID);
        int buffer = bufferCalculator.calculate(product);
        if (!alreadyOnOrder(product, buffer) && needsReordering(quantity, product, buffer)){
            notification.send("Please order more of product " + productID + ": '" + product.getDescription() + "'");
        }
    }

    private boolean needsReordering(int quantity, Product product, int buffer) {
        return product.getStockLevel() - quantity <= buffer;
    }

    private boolean alreadyOnOrder(Product product, int buffer) {
        return product.getStockLevel() <= buffer;
    }
}
