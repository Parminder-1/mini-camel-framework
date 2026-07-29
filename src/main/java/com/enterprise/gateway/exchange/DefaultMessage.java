package com.enterprise.gateway.exchange;

import java.util.HashMap;
import java.util.Map;

public class DefaultMessage implements Message {

    private Object body;
    private final Map<String, Object> headers =new HashMap<>();
    @Override
    public Object getBody() {
        return body;
    }

    @Override
    public void setBody(Object body) {
        this.body = body;
    }

    @Override
    public Object getHeader(String name) {
        return headers.get(name);
    }

    @Override
    public void setHeader(String name, Object value) {
        headers.put(name, value);
    }

    @Override
    public Map<String, Object> getHeaders() {
        return headers;
    }

}