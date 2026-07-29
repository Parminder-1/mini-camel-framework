package com.enterprise.gateway.security;

import com.enterprise.gateway.exchange.Exchange;
import com.enterprise.gateway.processor.Processor;

public class AuthenticationProcessor implements Processor {

    @Override
    public void process(Exchange exchange) {
        String token = (String)exchange.getIn().getHeader("Authorization");

        if(token == null || !token.startsWith("Bearer ")) {
            throw new RuntimeException( "Invalid JWT");
        }

        System.out.println("Authentication Success");
    }

}
