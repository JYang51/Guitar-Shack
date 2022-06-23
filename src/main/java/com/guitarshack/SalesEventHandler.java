package com.guitarshack;

public class SalesEventHandler {

    private final Notification notification;

    public SalesEventHandler(Notification notification, Warehouse warehouse, Buffer bufferCalculator) {
        this.notification = notification;
    }

    public void onPurchase(int productID, int quantity) {
        notification.send("Hello");
    }
}
