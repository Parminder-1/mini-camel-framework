package com.enterprise.gateway.pipeline;

import com.enterprise.gateway.exchange.Exchange;
import com.enterprise.gateway.processor.Processor;

import java.util.ArrayList;
import java.util.List;

public class Pipeline {

    private final List<Processor> processors = new ArrayList<>();

    public Pipeline process(Processor processor){

        processors.add(processor);

        return this;
    }

    public void process(Exchange exchange) throws Exception{

        for(Processor processor : processors){

            System.out.println("--------------------------------");
            System.out.println(processor.getClass().getSimpleName());
            System.out.println("--------------------------------");

            if(exchange.isRouteStopped()){
                break;
            }

            processor.process(exchange);

        }

    }

    public List<Processor> getProcessors(){

        return processors;
    }

}