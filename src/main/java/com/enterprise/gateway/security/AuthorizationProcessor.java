package com.enterprise.gateway.security;

import com.enterprise.gateway.exchange.Exchange;
import com.enterprise.gateway.processor.Processor;

public class AuthorizationProcessor  implements Processor {

    @Override
    public void process( Exchange exchange) {

        String role = (String)exchange.getIn().getHeader("Role");

        if(!"ADMIN".equals(role)) {
            throw new RuntimeException( "Access Denied");
        }

        System.out.println( "Authorization Success");

    }

}
