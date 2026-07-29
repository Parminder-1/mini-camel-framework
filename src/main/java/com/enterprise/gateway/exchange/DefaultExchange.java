package com.enterprise.gateway.exchange;

import java.util.HashMap;
import java.util.Map;

public class DefaultExchange implements Exchange {

    private final Message in = new DefaultMessage();
    private Message out = new DefaultMessage();
    private final Map<String, Object> properties =  new HashMap<>();
    private Exception exception;
    private boolean routeStopped;

    @Override
    public Message getIn() {
        return in;
    }

    @Override
    public Message getOut() {
        return out;
    }

    @Override
    public void setOut(Message message) {
        this.out = message;
    }

    @Override
    public Object getProperty(String key) {
        return properties.get(key);
    }

    @Override
    public void setProperty(String key,Object value) {
        properties.put(key, value);
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }

    @Override
    public Exception getException() {
        return exception;
    }

    @Override
    public void setException(Exception exception) {
        this.exception = exception;
    }

    @Override
    public boolean isRouteStopped() {
        return routeStopped;
    }

    @Override
    public void stop() {
        routeStopped = true;
    }

}