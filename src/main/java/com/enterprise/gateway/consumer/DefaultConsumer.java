package com.enterprise.gateway.consumer;

import com.enterprise.gateway.route.Endpoint;
import com.enterprise.gateway.gateway.GatewayEngine;

public abstract class DefaultConsumer implements Consumer {

    protected final Endpoint endpoint;

    protected final GatewayEngine gateway;

    protected DefaultConsumer(
            Endpoint endpoint,
            GatewayEngine gateway) {

        this.endpoint = endpoint;
        this.gateway = gateway;
    }

}
