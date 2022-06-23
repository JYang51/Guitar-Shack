package com.guitarshack;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckProductNeedsReorderingSteps {
    private Notification notification;
    private SalesEventHandler salesEventHandler;

    @Given("{int} is greater than {int}")
    public void stockLevelIsGreaterThanBuffer(int stockLevel, int buffer) {

        notification = mock(Notification.class);
        Warehouse warehouse = productID -> new Product(stockLevel);
        Buffer bufferCalculator = product -> buffer;

        salesEventHandler = new SalesEventHandler(notification, warehouse, bufferCalculator);

    }

    @When("The {int} is purchased in a {int} that lowers the stock level to or below the buffer")
    public void theProductIsPurchasedInAQuantityThatLowersTheStockLevelToOrBelowTheBuffer(int productID, int quantity) {
        salesEventHandler.onPurchase(productID, quantity);
    }

    @Then("A {string} is sent to the store manager to order more product")
    public void aNotificationIsSentToTheStoreManagerToOrderMoreProduct(String message) {
        verify(notification).send(any());
    }
}
