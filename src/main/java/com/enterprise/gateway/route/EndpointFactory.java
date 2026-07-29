package com.enterprise.gateway.route;

import com.enterprise.gateway.component.Component;
import com.enterprise.gateway.component.ComponentRegistry;

public class EndpointFactory {

    private final ComponentRegistry registry;

    public EndpointFactory(ComponentRegistry registry) {
        this.registry = registry;
    }

    public Endpoint createEndpoint(String uri) {

        String scheme =
                uri.substring(0, uri.indexOf(":"));

        String remaining =
                uri.substring(uri.indexOf(":") + 1);

        Component component =
                registry.getComponent(scheme);

        if(component == null){

            throw new RuntimeException(
                    "Unknown Component : " + scheme);

        }

        return component.createEndpoint(remaining);

    }

}