package com.enterprise.gateway.gateway;

import com.enterprise.gateway.pipeline.Pipeline;
import com.enterprise.gateway.route.Endpoint;

public interface GatewayRoute {

    Endpoint getFrom();

    Pipeline getPipeline();

    Endpoint getTo();
}
/*
import com.enterprise.gateway.exception.GatewayException;
import com.enterprise.gateway.exchange.Exchange;
import com.enterprise.gateway.processor.Processor;

import java.util.List;

public interface GatewayRoute {

    /**
     * Add a processor to the route.
     */
  //  GatewayRoute process(Processor processor);

    /**
     * Execute the route.
     */
  //  void process(Exchange exchange) throws Exception;

    /**
     * Return all processors in this route.
     */
 //   List<Processor> getProcessors();
//
//}