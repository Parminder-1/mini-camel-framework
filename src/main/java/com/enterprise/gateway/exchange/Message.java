package com.enterprise.gateway.exchange;

import java.util.Map;

public interface Message {

    Object getBody();

    void setBody(Object body);

    Object getHeader(String name);

    void setHeader(String name, Object value);

    Map<String, Object> getHeaders();

}