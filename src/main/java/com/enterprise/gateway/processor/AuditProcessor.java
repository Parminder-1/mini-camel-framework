package com.enterprise.gateway.processor;

import com.enterprise.gateway.dto.OrderRequest;
import com.enterprise.gateway.dto.OrderRequest;
import com.enterprise.gateway.exchange.Exchange;
import com.enterprise.gateway.processor.Processor;
import org.springframework.stereotype.Component;

public class AuditProcessor implements Processor {

    @Override
    public void process(Exchange exchange) {

        OrderRequest request = (OrderRequest)exchange.getIn().getBody();
        System.out.println("===== Audit Processor =====");
        System.out.println("Customer : " + request.getCustomerId());
        System.out.println("Product  : " + request.getProductId());
        System.out.println("Quantity : " + request.getQuantity());

    }
}