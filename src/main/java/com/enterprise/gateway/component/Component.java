package com.enterprise.gateway.component;

import com.enterprise.gateway.route.Endpoint;

public interface Component {

    Endpoint createEndpoint(String uri);

}
/**
 com.enterprise.gateway
 │
 ├── component
 │      Component.java
 │      ComponentRegistry.java
 │      HttpComponent.java
 │      KafkaComponent.java
 │
 ├── endpoint
 │      Endpoint.java
 │      HttpEndpoint.java
 │      KafkaEndpoint.java
 │      EndpointFactory.java
 │
 ├── producer
 │      Producer.java
 │      KafkaProducer.java
 │
 ├── context
 │      CamelContext.java
 │      DefaultCamelContext.java

 mini-camel
 │
 ├── camel-api
 │      Exchange
 │      Processor
 │      Endpoint
 │      Producer
 │      Consumer
 │
 ├── camel-core
 │      CamelContext
 │      DefaultCamelContext
 │      Pipeline
 │      Route
 │      RouteBuilder
 │      ComponentRegistry
 │
 ├── camel-http
 │      HttpComponent
 │      HttpEndpoint
 │      HttpConsumer
 │
 ├── camel-kafka
 │      KafkaComponent
 │      KafkaEndpoint
 │      KafkaProducer
 │
 └── demo
 OrderController
 OrderRoute
 */