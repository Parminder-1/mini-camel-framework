package com.enterprise.gateway.route;

import com.enterprise.gateway.route.Endpoint;
import com.enterprise.gateway.route.KafkaProducer;

public class KafkaEndpoint extends Endpoint {

    public KafkaEndpoint(String topic) {
        super(topic);
    }

    @Override
    public KafkaProducer createProducer() {
        return new KafkaProducer(getUri());
    }

}