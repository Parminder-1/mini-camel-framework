package com.enterprise.gateway.component;

import com.enterprise.gateway.route.Endpoint;
import com.enterprise.gateway.route.KafkaEndpoint;

public class KafkaComponent implements Component {

    @Override
    public Endpoint createEndpoint(String uri) {

        return new KafkaEndpoint(uri);

    }

}