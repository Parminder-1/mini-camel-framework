package com.enterprise.gateway.processor;

import com.enterprise.gateway.dto.OrderRequest;
import com.enterprise.gateway.exchange.Exchange;
import com.enterprise.gateway.processor.Processor;

import org.springframework.stereotype.Component;

public class ValidationProcessor implements Processor {


    @Override
    public void process(Exchange exchange) {

        OrderRequest request =(OrderRequest)exchange.getIn().getBody();
        System.out.println("===== Validation Processor =====");

        if (request.getCustomerId() == null ||
                request.getCustomerId().isBlank()) {

            throw new IllegalArgumentException(
                    "Customer Id is required");
        }

        if (request.getProductId() == null ||
                request.getProductId().isBlank()) {

            throw new IllegalArgumentException(
                    "Product Id is required");
        }

        if (request.getQuantity() <= 0) {

            throw new IllegalArgumentException(
                    "Quantity must be greater than zero");
        }

    }
}