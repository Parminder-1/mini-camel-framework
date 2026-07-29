package com.enterprise.gateway.kafka;

import com.enterprise.gateway.exchange.Exchange;
import com.enterprise.gateway.processor.Processor;

public class KafkaProducerProcessor implements Processor {

    @Override
    public void process( Exchange exchange) {
        System.out.println( "Publishing Order To Kafka");
        System.out.println(exchange.getIn().getBody());
    }
}