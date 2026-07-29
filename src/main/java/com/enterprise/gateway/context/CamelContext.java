package com.enterprise.gateway.context;

import com.enterprise.gateway.component.Component;
import com.enterprise.gateway.route.EndpointFactory;
import com.enterprise.gateway.gateway.GatewayRoute;

public interface CamelContext {

    void addComponent(String scheme, Component component);

    void addRoute(String uri, GatewayRoute route);

    GatewayRoute getRoute(String uri);

    Component getComponent(String scheme);

    EndpointFactory getEndpointFactory();

    void start();

    void stop();
}