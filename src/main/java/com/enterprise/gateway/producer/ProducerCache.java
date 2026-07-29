package com.enterprise.gateway.producer;

import com.enterprise.gateway.route.Endpoint;

import java.util.HashMap;
import java.util.Map;

public class ProducerCache {

    private final Map<String, Producer> cache =
            new HashMap<>();

    public Producer getProducer(
            Endpoint endpoint){

        return cache.computeIfAbsent(
                endpoint.getUri(),
                uri -> endpoint.createProducer());
    }

}
