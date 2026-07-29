package com.enterprise.gateway.component;

import com.enterprise.gateway.route.Endpoint;
import com.enterprise.gateway.route.HttpEndpoint;

public class HttpComponent implements Component {

    @Override
    public Endpoint createEndpoint(String uri) {

        return new HttpEndpoint(uri);

    }

}
