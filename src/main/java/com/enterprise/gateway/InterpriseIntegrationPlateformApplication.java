package com.enterprise.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 At that point, your framework will have the same core architectural ideas as Apache Camel:

 Exchange – the message container.
 Processor – transforms or processes the message.
 Pipeline – chains processors.
 Route – connects source, processing, and destination.
 Endpoint – describes where messages come from or go to.
 Producer – sends an Exchange to a destination.
 Consumer – receives messages from a source.

 From there, implementing a Camel-like DSL such as:

 new RouteBuilder()
 .from("http:/orders")
 .process(new AuthenticationProcessor())
 .process(new ValidationProcessor())
 .to("kafka:orders-topic");

 will be a natural next step, because the underlying architecture will already be in place.
 framework-from-scratch
 ├── mini-spring
 ├── mini-camel
 ├── mini-kafka
 ├── mini-netty
 └── notes
 */
@SpringBootApplication
public class InterpriseIntegrationPlateformApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterpriseIntegrationPlateformApplication.class, args);
    }

}
