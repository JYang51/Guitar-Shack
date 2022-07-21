package com.guitarshack;

import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ProductWarehouse implements Warehouse {
    @Override
    public Product fetchProduct(int productID) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(List.of(new MyGsonHttpMessageConverter()));

        ProductData productData = restTemplate.getForObject("https://6hr1390c1j.execute-api.us-east-2.amazonaws.com/default/product?id=" + productID, ProductData.class);

        return new Product(productData.stock, productData.description, productData.leadTime, productData.id);
    }
}
