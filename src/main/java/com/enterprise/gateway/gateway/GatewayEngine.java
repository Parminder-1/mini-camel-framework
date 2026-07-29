package com.enterprise.gateway.gateway;

import com.enterprise.gateway.context.CamelContext;
import com.enterprise.gateway.exchange.Exchange;
import com.enterprise.gateway.producer.Producer;

public class GatewayEngine {

    private final CamelContext camelContext;

    public GatewayEngine(CamelContext camelContext) {

        this.camelContext = camelContext;

    }

    public void process(String uri,
                        Exchange exchange) throws Exception {

        GatewayRoute route =
                camelContext.getRoute(uri);

        if(route == null){

            throw new RuntimeException(
                    "No Route Found : " + uri);

        }

        route.getPipeline().process(exchange);

        Producer producer =  route.getTo().createProducer();



        producer.process(exchange);

    }

}