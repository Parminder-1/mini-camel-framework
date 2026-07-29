package com.enterprise.gateway.context;

import com.enterprise.gateway.component.Component;
import com.enterprise.gateway.component.ComponentRegistry;
import com.enterprise.gateway.consumer.Consumer;
import com.enterprise.gateway.consumer.ConsumerManager;
import com.enterprise.gateway.gateway.GatewayEngine;
import com.enterprise.gateway.gateway.GatewayRoute;
import com.enterprise.gateway.route.EndpointFactory;

import java.util.HashMap;
import java.util.Map;

public class DefaultCamelContext implements CamelContext {

    private final ComponentRegistry componentRegistry =
            new ComponentRegistry();
    private final EndpointFactory endpointFactory =
            new EndpointFactory(componentRegistry);

    private final Map<String, GatewayRoute> routes =
            new HashMap<>();

    @Override
    public void addComponent(String scheme,
                             Component component) {

        componentRegistry.register(scheme, component);

    }

    @Override
    public void addRoute(String uri,
                         GatewayRoute route) {

        routes.put(uri, route);

        System.out.println("Route Registered : " + uri);

    }

    @Override
    public GatewayRoute getRoute(String uri) {

        return routes.get(uri);

    }

    @Override
    public Component getComponent(String scheme) {

        return componentRegistry.getComponent(scheme);

    }
    @Override
    public EndpointFactory getEndpointFactory() {
        return endpointFactory;
    }
/**
    @Override
    public void start() {

        System.out.println();
        System.out.println("========================================");
        System.out.println(" Mini CamelContext Started");
        System.out.println("========================================");

        System.out.println("Routes : " + routes.size());

        routes.keySet().forEach(System.out::println);

        System.out.println();

    }
*/
public void start(){

    System.out.println();

    System.out.println("===============================");
    System.out.println(" Mini Camel Started");
    System.out.println("===============================");

    ConsumerManager manager =
            new ConsumerManager();

    GatewayEngine gateway =
            new GatewayEngine(this);

    routes.values().forEach(route -> {

        Consumer consumer =
                route.getFrom()
                        .createConsumer(gateway);

        if(consumer != null){

            manager.addConsumer(
                    consumer);

        }

    });

    manager.start();

}
    @Override
    public void stop() {

        System.out.println("Mini CamelContext Stopped");

    }

}