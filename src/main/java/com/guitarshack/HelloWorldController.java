package com.guitarshack;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@RestController
public class HelloWorldController {
    private String messageSent = "";
    @GetMapping("/onpurchase/{id}/{quantity}")
    public String onPurchase(@PathVariable int id, @PathVariable int quantity) {
        Notification notification = message -> messageSent = message;
        SalesEventHandler salesEventHandler = new SalesEventHandler(
                notification,
                new ProductWarehouse(
                        new RestTemplate()
                ),
                new StockBuffer(
                        new AverageDailySalesCalculator(
                                new ProductSalesHistory(
                                        new RestTemplate()
                                ),
                                LocalDate.now()
                        )
                )
        );
        salesEventHandler.onPurchase(id, quantity);
        return messageSent;
    }
}
