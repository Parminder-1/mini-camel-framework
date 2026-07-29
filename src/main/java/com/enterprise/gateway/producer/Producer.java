package com.enterprise.gateway.producer;

import com.enterprise.gateway.exchange.Exchange;

public interface Producer {

    void process(Exchange exchange) throws Exception;

}