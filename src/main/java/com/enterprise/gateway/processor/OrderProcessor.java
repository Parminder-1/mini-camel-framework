package com.enterprise.gateway.processor;

import com.enterprise.gateway.dto.OrderRequest;
import com.enterprise.gateway.dto.OrderResponse;


import com.enterprise.gateway.exchange.Exchange;
import org.springframework.stereotype.Component;

import java.util.UUID;


public class OrderProcessor implements Processor {

    @Override
    public void process(Exchange exchange) {



        OrderRequest request = (OrderRequest)exchange.getIn().getBody();
        System.out.println(exchange.getIn().getBody());
        System.out.println("--------------------------------");
        System.out.println("Order Processor");
        System.out.println("--------------------------------");

        System.out.println("Customer : " + request.getCustomerId());
        System.out.println("Product  : " + request.getProductId());
        System.out.println("Quantity : " + request.getQuantity());

        OrderResponse response = new OrderResponse();
        response.setOrderId(UUID.randomUUID().toString());
        response.setStatus("CREATED");
        exchange.getIn().setBody(response);

    }

}