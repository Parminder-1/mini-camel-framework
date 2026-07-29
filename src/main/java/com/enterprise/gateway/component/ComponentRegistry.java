package com.enterprise.gateway.component;

import java.util.HashMap;
import java.util.Map;

public class ComponentRegistry {

    private final Map<String, Component> components = new HashMap<>();

    public void register(String scheme, Component component){

        components.put(scheme, component);

        System.out.println("Component Registered : " + scheme);

    }

    public Component getComponent(String scheme){

        Component component = components.get(scheme);

        if(component == null){

            throw new RuntimeException(
                    "Component not found : " + scheme);

        }

        return component;
    }

}