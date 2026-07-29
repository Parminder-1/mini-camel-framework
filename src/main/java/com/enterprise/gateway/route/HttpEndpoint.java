package com.enterprise.gateway.route;


import com.enterprise.gateway.consumer.Consumer;
import com.enterprise.gateway.consumer.HttpConsumer;
import com.enterprise.gateway.gateway.GatewayEngine;

public class HttpEndpoint extends Endpoint {

    public HttpEndpoint(String uri){

        super(uri);

    }

    @Override
    public Consumer createConsumer(GatewayEngine gateway){

        return new HttpConsumer( this, gateway);


    }

}