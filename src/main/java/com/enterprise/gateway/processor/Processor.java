package com.enterprise.gateway.processor;

import com.enterprise.gateway.exchange.Exchange;

@FunctionalInterface
public interface Processor {

    /**
     * Process the current Exchange.
     *
     * @param exchange Request/Response container flowing through the pipeline
     * @throws Exception if processing fails
     */
    void process(Exchange exchange) throws Exception;

}
