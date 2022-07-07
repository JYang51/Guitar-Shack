package com.guitarshack;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ProductSalesHistory implements SalesHistory {
    @Override
    public int totalSales(int productID, LocalDate startDate, LocalDate endDate) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(List.of(new MyGsonHttpMessageConverter()));
        SalesTotal salesTotal = restTemplate.getForObject("https://gjtvhjg8e9.execute-api.us-east-2.amazonaws.com/default/sales?productId=811&startDate=7%2F17%2F2021&endDate=7%2F27%2F2021&action=total", SalesTotal.class);
        return salesTotal.total;
    }

    public class MyGsonHttpMessageConverter extends GsonHttpMessageConverter {
        public MyGsonHttpMessageConverter() {
            List<MediaType> types = Arrays.asList(
                    new MediaType("text", "html", DEFAULT_CHARSET),
                    new MediaType("application", "json", DEFAULT_CHARSET),
                    new MediaType("application", "*+json", DEFAULT_CHARSET)
            );
            super.setSupportedMediaTypes(types);
        }
    }
}