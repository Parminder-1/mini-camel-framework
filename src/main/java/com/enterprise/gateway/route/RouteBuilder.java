package com.enterprise.gateway.route;

import com.enterprise.gateway.route.EndpointFactory;
import com.enterprise.gateway.gateway.DefaultGatewayRoute;
import com.enterprise.gateway.gateway.GatewayRoute;
import com.enterprise.gateway.processor.Processor;

public class RouteBuilder {

    private final EndpointFactory endpointFactory;

    private final DefaultGatewayRoute route =
            new DefaultGatewayRoute();

    public RouteBuilder(EndpointFactory endpointFactory) {

        this.endpointFactory = endpointFactory;

    }

    public RouteBuilder from(String uri){

        route.from(
                endpointFactory.createEndpoint(uri));

        return this;

    }

    public RouteBuilder process(Processor processor){

        route.process(processor);

        return this;

    }

    public GatewayRoute to(String uri){

        route.to(
                endpointFactory.createEndpoint(uri));

        return route;

    }

}
