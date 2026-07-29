package com.enterprise.gateway.consumer;


import java.util.ArrayList;
import java.util.List;

public class ConsumerManager {

    private final List<Consumer> consumers =  new ArrayList<>();

    public void addConsumer( Consumer consumer){
        consumers.add(consumer);
    }

    public void start() {
        consumers.forEach(Consumer::start);
    }

    public void stop(){
        consumers.forEach(Consumer::stop);
    }

}