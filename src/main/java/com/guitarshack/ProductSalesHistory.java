package com.guitarshack;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ProductSalesHistory implements SalesHistory {

    private final RestTemplate restTemplate;

    public ProductSalesHistory(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public int totalSales(int productID, LocalDate startDate, LocalDate endDate) {
        RestTemplate restTemplate = this.restTemplate;
        restTemplate.setMessageConverters(List.of(new MyGsonHttpMessageConverter()));
        SalesTotal salesTotal = restTemplate.getForObject("https://gjtvhjg8e9.execute-api.us-east-2.amazonaws.com/default/sales?productId=" + productID + "&startDate=7/17/2021&endDate=7/27/2021&action=total", SalesTotal.class);
        return salesTotal.total;
    }

    public class MyGsonHttpMessageConverter extends GsonHttpMessageConverter {
        public MyGsonHttpMessageConverter() {
            List<MediaType> types = Arrays.asList(
                    new MediaType("text", "plain", DEFAULT_CHARSET),
                    new MediaType("application", "json", DEFAULT_CHARSET),
                    new MediaType("application", "*+json", DEFAULT_CHARSET)
            );
            super.setSupportedMediaTypes(types);
        }
    }
}
