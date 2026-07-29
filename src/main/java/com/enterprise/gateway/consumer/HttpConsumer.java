package com.enterprise.gateway.consumer;

import com.enterprise.gateway.route.Endpoint;
import com.enterprise.gateway.gateway.GatewayEngine;

public class HttpConsumer extends DefaultConsumer {

    public HttpConsumer(
            Endpoint endpoint,
            GatewayEngine gateway) {

        super(endpoint, gateway);

    }

    @Override
    public void start() {

        System.out.println("--------------------------------");
        System.out.println("HTTP Consumer Started");
        System.out.println(endpoint.getUri());
        System.out.println("--------------------------------");

    }

    @Override
    public void stop() {

        System.out.println("HTTP Consumer Stopped");

    }

}