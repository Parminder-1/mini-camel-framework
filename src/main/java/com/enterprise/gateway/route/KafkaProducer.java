package com.enterprise.gateway.route;

import com.enterprise.gateway.exchange.Exchange;
import com.enterprise.gateway.producer.Producer;

public class KafkaProducer implements Producer {

    private final String topic;

    public KafkaProducer(String topic) {
        this.topic = topic;
    }

    @Override
    public void process(Exchange exchange) {

        System.out.println("--------------------------------");
        System.out.println("Kafka Producer");
        System.out.println("--------------------------------");

        System.out.println("Publishing to topic : " + topic);

        System.out.println(exchange.getIn().getBody());

        // kafkaTemplate.send(topic,...)

    }

}
