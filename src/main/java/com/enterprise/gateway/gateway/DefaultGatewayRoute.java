package com.enterprise.gateway.gateway;

import com.enterprise.gateway.pipeline.Pipeline;
import com.enterprise.gateway.processor.Processor;
import com.enterprise.gateway.route.Endpoint;

public class DefaultGatewayRoute implements GatewayRoute {

    private Endpoint from;

    private Pipeline pipeline = new Pipeline();

    private Endpoint to;

    public DefaultGatewayRoute from(Endpoint endpoint){

        this.from = endpoint;
        return this;
    }

    public DefaultGatewayRoute process(Processor processor){

        pipeline.process(processor);
        return this;
    }

    public DefaultGatewayRoute to(Endpoint endpoint){

        this.to = endpoint;
        return this;
    }

    @Override
    public Endpoint getFrom() {
        return from;
    }

    @Override
    public Pipeline getPipeline() {
        return pipeline;
    }

    @Override
    public Endpoint getTo() {
        return to;
    }
}
/**
import com.enterprise.gateway.exception.GatewayException;
import com.enterprise.gateway.exchange.Exchange;
import com.enterprise.gateway.processor.Processor;

import java.util.ArrayList;
import java.util.List;

public class DefaultGatewayRoute implements GatewayRoute {

    private final List<Processor> processors = new ArrayList<>();

    @Override
    public GatewayRoute process(Processor processor) {
        processors.add(processor);
        return this;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        for (Processor processor : processors) {

            System.out.println("--------------------------------");
            System.out.println(processor.getClass().getSimpleName());
            System.out.println("--------------------------------");
            if (exchange.isRouteStopped()) {
                break;
            }
            processor.process(exchange);
        }
    }

    @Override
    public List<Processor> getProcessors() {
        return processors;
    }
}
 */