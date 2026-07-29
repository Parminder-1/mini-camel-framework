package com.enterprise.gateway.route;

import com.enterprise.gateway.consumer.Consumer;
import com.enterprise.gateway.gateway.GatewayEngine;
import com.enterprise.gateway.producer.Producer;

public abstract class Endpoint {

    private final String uri;

    protected Endpoint(String uri){

        this.uri = uri;

    }

    public String getUri(){

        return uri;

    }

    public Producer createProducer(){

        throw new UnsupportedOperationException();

    }

    public Consumer createConsumer(
            GatewayEngine gateway){

        throw new UnsupportedOperationException();

    }

}