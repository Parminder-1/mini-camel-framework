package com.enterprise.gateway.route;

import com.enterprise.gateway.context.CamelContext;
import com.enterprise.gateway.route.RouteBuilder;
import com.enterprise.gateway.gateway.GatewayRoute;
import com.enterprise.gateway.processor.AuditProcessor;
import com.enterprise.gateway.processor.OrderProcessor;
import com.enterprise.gateway.processor.ValidationProcessor;
import com.enterprise.gateway.security.AuthenticationProcessor;
import com.enterprise.gateway.security.AuthorizationProcessor;

public class OrderRoute {

    private final CamelContext camelContext;

    public OrderRoute(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    public GatewayRoute createRoute() {

        return new RouteBuilder(camelContext.getEndpointFactory())
                .from("http:/orders")
                .process(new AuthenticationProcessor())
                .process(new AuthorizationProcessor())
                .process(new ValidationProcessor())
                .process(new AuditProcessor())
                .process(new OrderProcessor())
                .to("kafka:orders-topic");
    }
}

/**
public class OrderRoute {

    public GatewayRoute createRoute() {

        return new DefaultGatewayRoute()

                .from(new HttpEndpoint("/orders"))

                .process(new AuthenticationProcessor())
                .process(new AuthorizationProcessor())
                .process(new ValidationProcessor())
                .process(new AuditProcessor())
                .process(new OrderProcessor())

                .to(new KafkaEndpoint("orders-topic"));
    }
}


import com.enterprise.gateway.gateway.DefaultGatewayRoute;
import com.enterprise.gateway.gateway.GatewayRoute;
import com.enterprise.gateway.kafka.KafkaProducerProcessor;
import com.enterprise.gateway.processor.AuditProcessor;
import com.enterprise.gateway.processor.OrderProcessor;
import com.enterprise.gateway.processor.ValidationProcessor;
import com.enterprise.gateway.security.AuthenticationProcessor;
import com.enterprise.gateway.security.AuthorizationProcessor;

public class OrderRoute {

    public GatewayRoute createRoute() {

        return new DefaultGatewayRoute()
                .process(new AuthenticationProcessor())
                .process(new AuthorizationProcessor())
                .process(new ValidationProcessor())
                .process(new AuditProcessor())
                .process(new OrderProcessor())          // Business logic
                .process(new KafkaProducerProcessor()); // Publish event
    }
}
 */