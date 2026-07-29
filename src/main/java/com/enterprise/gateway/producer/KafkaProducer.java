package com.enterprise.gateway.producer;

import com.enterprise.gateway.exchange.Exchange;

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

        System.out.println("Publishing To Topic : " + topic);

        System.out.println(exchange.getIn().getBody());

        // kafkaTemplate.send(topic, exchange.getIn().getBody());

    }
}